package com.example.cardgame

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardgame.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.content.res.AssetManager
import android.content.res.Resources
import android.graphics.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Game
    private lateinit var cardImageView: ImageView
    private lateinit var flipInAnimator: AnimatorSet
    private lateinit var flipOutAnimator: AnimatorSet

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadJsonFromAssets("atlas.json")

        game = Game(1, 3)  // Ініціалізуйте гру тут з 3 гравцями
        binding.tvRole.text = "Role: ${game.players[0].role}" // Відображення ролі гравця

        // створення картинок
        createCardBitmap(R.drawable.atlas, 100, 100)
        createCardBitmap(R.drawable.atlas, 200, 200)
        createCardBitmap(R.drawable.atlas, 300, 300)
        createCardBitmap(R.drawable.atlas, 400, 400)

        // відображення картинок на екрані
        cardImageView = findViewById(R.id.cardImageView)
        cardImageView.setImageBitmap(card1Bitmap)



        // Завантажте анімації з XML-файлів
        flipInAnimator = AnimatorInflater.loadAnimator(this, R.animator.card_flip_in) as AnimatorSet
        flipOutAnimator = AnimatorInflater.loadAnimator(this, R.animator.card_flip_out) as AnimatorSet

        cardImageView.setOnClickListener {
            flipCard()
        }

        // Використовуйте клас `Game` для обробки ходів, наприклад:
        val currentPlayer = game.getCurrentPlayer()
        if (currentPlayer is Bot) {
            val cardToPlay = currentPlayer.chooseCard(game)
            if (cardToPlay != null) {
                game.playCard(currentPlayer, cardToPlay)
            }
        }

        // Налаштування RecyclerView для відображення карт гравця
        val player1Adapter = CardsAdapter(game.players[0].cards, isCurrentUser = true)
        val player2Adapter = CardsAdapter(game.players[1].cards, isCurrentUser = false)
        val player3Adapter = CardsAdapter(game.players[2].cards, isCurrentUser = false)
        val player4Adapter = CardsAdapter(game.players[3].cards, isCurrentUser = false)

        binding.rvPlayer1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPlayer1.adapter = player1Adapter

        binding.rvPlayer2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPlayer2.adapter = player2Adapter

        binding.rvPlayer3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPlayer3.adapter = player3Adapter

        binding.rvPlayer4.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPlayer4.adapter = player4Adapter

        // Обробка кліків на кнопку "Start Game"
        binding.btnStartGame.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                // Реалізуйте логіку старту гри та обробки ходів гравців
                // Наприклад: змініть статус гри, змініть хід гравця, відправте повідомлення мультиплеєру, тощо

                // Оновлення UI в основному потоц
                // Оновлення UI в основному потоці
                withContext(Dispatchers.Main) {
                    // Оновлення карт гравця
                    player1Adapter.notifyDataSetChanged()
                    player2Adapter.notifyDataSetChanged()
                    player3Adapter.notifyDataSetChanged()
                    player4Adapter.notifyDataSetChanged()

                    // Відображення ролі гравця
                    binding.tvRole.text = "Role: ${game.players[0].role}"
                }
            }
        }
    }
    fun createCardBitmap(imageResourceId: Int, x: Int, y: Int): Bitmap {
        val resources: Resources = Resources.getSystem()
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, imageResourceId)
        val cardWidth: Int = bitmap.width / 13 // 13 карт в ряду
        val cardHeight: Int = bitmap.height / 4 // 4 масті
        val cardBitmap = Bitmap.createBitmap(bitmap, x, y, cardWidth, cardHeight)
        val canvas: Canvas = Canvas(cardBitmap)
        val paint: Paint = Paint()
        canvas.drawBitmap(cardBitmap, 1000.toFloat(), 1000.toFloat(), paint)
        return cardBitmap // повертаємо cardBitmap з функції
    }
    private fun loadJsonFromAssets(atlas: String): String {
        val assetManager: AssetManager = assets
        val inputStream = assetManager.open(atlas)
        return inputStream.bufferedReader().use { it.readText() }
    }
    private fun parseJson(jsonString: String): Map<String, RectF> {
        val map = mutableMapOf<String, RectF>()
        val json = JSONObject(jsonString)
        val frames = json.getJSONObject("frames")
        val meta = json.getJSONObject("meta")
        val frameSize = PointF(meta.getInt("size").toFloat(), meta.getInt("size").toFloat())

        for (key in frames.keys()) {
            val frame = frames.getJSONObject(key)
            val rect = RectF(
                frame.getJSONObject("frame").getInt("x").toFloat() / frameSize.x,
                frame.getJSONObject("frame").getInt("y").toFloat() / frameSize.y,
                (frame.getJSONObject("frame").getInt("x") + frame.getJSONObject("frame").getInt("w")).toFloat() / frameSize.x,
                (frame.getJSONObject("frame").getInt("y") + frame.getJSONObject("frame").getInt("h")).toFloat() / frameSize.y
            )
            map[key] = rect
        }

        return map
    }

    private fun flipCard() {
        // Виконайте анімацію перевороту карт
        if (cardImageView.rotationY == 0f) {
            flipInAnimator.setTarget(cardImageView)
            flipInAnimator.start()
        } else {
            flipOutAnimator.setTarget(cardImageView)
            flipOutAnimator.start()
        }
        fun cardBitmap(atlas: Int, x: Int, y: Int): Bitmap {
            val resources: Resources = Resources.getSystem()
            val bitmap: Bitmap = BitmapFactory.decodeResource(resources, atlas)
            val cardWidth: Int = bitmap.width / 13 // 13 карт в ряду
            val cardHeight: Int = bitmap.height / 4 // 4 масті
            val cardBitmap = Bitmap.createBitmap(bitmap, x, y, cardWidth, cardHeight)
            val canvas: Canvas = Canvas(cardBitmap)
            val paint: Paint = Paint()
            canvas.drawBitmap(cardBitmap, 5058.toFloat(), 1894.toFloat(), paint)
            return cardBitmap // повертаємо cardBitmap з функції
        }
        }

}