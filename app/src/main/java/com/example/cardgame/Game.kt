package com.example.cardgame

class Game(val numberOfPlayers: Int, val numberOfBots: Int) {
    private val deck: Deck = Deck()
    val players: MutableList<Player> = mutableListOf()

    private var currentPlayerIndex = 0

    init {
        createPlayers()
        dealCards()
    }

    private fun createPlayers() {
        repeat(numberOfPlayers - numberOfBots) {
            players.add(Player())
        }
        repeat(numberOfBots) {
            players.add(SmartBot()) // Або інший тип бота
        }
    }

    private fun dealCards() {
        deck.shuffle()
        players.forEach { player ->
            repeat(5) {
                player.addCard(deck.drawCard())
            }
        }
    }

    fun playCard(player: Player, card: Card): Boolean {
        if (player.cards.contains(card)) {
            // Ваша логіка для обробки ходів тут, наприклад перевірка на відповідність правилам гри
            player.removeCard(card)

            // Визначте, хто зробить наступний хід
            nextPlayerTurn()

            return true
        } else {
            return false
        }
    }

    private fun nextPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers
    }

    fun getCurrentPlayer(): Player {
        return players[currentPlayerIndex]
    }
}
