package com.example.cardgame
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardgame.databinding.ItemCardBinding

class CardsAdapter(
    private val cards: List<Card>,
    private val isCurrentUser: Boolean
) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]

        // Якщо isCurrentUser == true, відображайте зображення карт; інакше відображайте зображення зворотнього боку карт
        val cardImageResId = if (isCurrentUser) {
            card.imageResourceId
        } else {
            R.drawable.atlas
        }

        holder.binding.ivCard.setImageResource(cardImageResId)
    }

    override fun getItemCount() = cards.size
}
