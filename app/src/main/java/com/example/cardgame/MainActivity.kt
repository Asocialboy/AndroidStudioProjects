package com.example.cardgame

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cardgame.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Game
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = Game(1, 3)  // Ініціалізуйте гру тут з 3 гравцями
        binding.tvRole.text = "Role: ${game.players[0].role}" // Відображення ролі гравця
        // Використовуйте клас `Game` для обробки ходів, наприклад:
        val currentPlayer = game.getCurrentPlayer()
        if (currentPlayer is Bot) {
            val cardToPlay = currentPlayer.chooseCard(game)
            if (cardToPlay != null) {
                game.playCard(currentPlayer, cardToPlay)
            }
        }
        // Обробка кліків на кнопку "Start Game"
        binding.btnStartGame.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                // Реалізуйте логіку старту гри та обробки ходів гравців
                // Наприклад: змініть статус гри, змініть хід гравця, відправте повідомлення мультиплеєру, тощо
                // Оновлення UI в основному потоц
                // Оновлення UI в основному потоці
                withContext(Dispatchers.Main) {
                    // Відображення ролі гравця
                    binding.tvRole.text = "Role: ${game.players[0].role}"
                }
                }
            }
        }
    }