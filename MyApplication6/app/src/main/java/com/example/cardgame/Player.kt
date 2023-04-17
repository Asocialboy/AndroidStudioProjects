package com.example.cardgame

open class Player(var role: Role = Role.NONE) {
    private val _cards: MutableList<Card> = mutableListOf()
    open val cards: List<Card>
        get() = _cards


    fun addCard(card: Card) {
        _cards.add(card)
    }

    fun removeCard(card: Card) {
        _cards.remove(card)
    }

    fun reset() {
        _cards.clear()
    }
}