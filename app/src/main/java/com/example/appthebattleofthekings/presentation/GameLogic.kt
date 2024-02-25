package com.example.appthebattleofthekings.presentation

import com.example.appthebattleofthekings.game.Player

interface GameLogic {

    fun battle()

    fun health(): String

    fun attack(): String

    fun isNotFinish(): Boolean

    fun winner(player: Player, bot: Player): String

    class Base(
        private val playerUser: Player,
        private val playerBot: Player
    ) : GameLogic {
        override fun battle() {
            if (isNotFinish()) {
                attack()
                health()
            }

        }

        override fun health(): String {
            var history = ""
            playerUser.health(playerUser.medicine)
            history = history + "${playerUser.name} health ${playerUser.medicine} \n"
            playerBot.health(playerBot.medicine)
            history = history + "${playerBot.name} health ${playerBot.medicine} \n"
            return history
        }

        override fun attack(): String {
            var history = ""
            playerUser.attack(playerBot, playerUser.gun)
            history =
                history + "${playerUser.name} <Health Point:${playerUser.hp}> \n attack ${playerBot.name} with gun:${playerUser.gun} \n"

            playerBot.attack(playerUser, playerBot.gun)
            history =
                history + "${playerBot.name} <Health Point:${playerBot.hp}> \n attack ${playerUser.name} with gun:${playerBot.gun} \n"
            return history
        }

        override fun isNotFinish(): Boolean {
            var result = true

            if (playerUser.hp <= 10) {
                println("${playerUser.name} вбитий гравцем ${playerBot.name}")
                result = false

            } else if (playerBot.hp <= 10) {
                println("${playerBot.name} вбитий гравцем ${playerUser.name}")
                result = false
            }

            return result
        }

        override fun winner(player: Player, bot: Player): String {

            return if (player.hp == bot.hp) {
                player.hp = 100
                bot.hp = 100
                "Not winner"
            } else if(player.hp >= bot.hp) {
                player.hp = 100
                bot.hp = 100
                "Winner: ${player.name} \n loser: ${bot.name}"
            } else {
                player.hp = 100
                bot.hp = 100
                "Winner: ${bot.name} \n loser: ${player.name}"
            }
        }
    }
}

