package com.example.cardgame

class SmartBot(role: Role = Role.NONE) : Bot(role) {
    override fun chooseCard(game: Game): Card? {
        // Розумна стратегія вибору картки
        // Змініть цю реалізацію відповідно до вашої гри та потреб
        return cards.maxByOrNull { it.rank.value }
    }
}
