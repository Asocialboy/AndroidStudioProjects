package com.example.cardgame

open class Bot(role: Role = Role.NONE) : Player(role) {
    open fun chooseCard(game: Game): Card? {
        // Базова реалізація бота: випадковий вибір картки
        return cards.shuffled().firstOrNull()
    }
}