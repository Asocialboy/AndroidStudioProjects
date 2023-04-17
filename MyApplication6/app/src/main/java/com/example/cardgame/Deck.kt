package com.example.cardgame

import com.example.cardgame.Card.Rank
import com.example.cardgame.Card.Suit
import kotlin.random.Random

class Deck {
    private val cards: MutableList<Card> = mutableListOf()

    init {
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                cards.add(Card(suit, rank))
            }
        }
    }

    fun shuffle() {
        cards.shuffle(Random.Default)
    }

    fun drawCard(): Card {
        return cards.removeAt(cards.lastIndex)
    }

    // ... (інші методи класу Deck, якщо вони є)
}
