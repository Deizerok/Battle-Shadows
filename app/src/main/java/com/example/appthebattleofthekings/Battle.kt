package com.example.appthebattleofthekings

class Battle(val player1: Player, val player2: Player) {

    var round = 1

    val medicine = arrayOf(
        Medicine("Tablet", 17),
        Medicine("Energetics", 19),
        Medicine("First aid kit", 23))

    val guns = arrayOf(
        Gun("AK-47", 20),
        Gun("M4-A1", 21),
        Gun("AWP", 29)
    )

    fun play() {   

        while (true) {

            if (isFinish()) break
            if(player1.hp >= 101) {
                player1.hp = 100
            } else if (player2.hp >= 101) {
                player2.hp = 100
            }
            println("РАУНД: ${round++}")

            player1.attack(player2, guns[0])
            player2.health(medicine[(Math.random() * medicine.size).toInt()])


            println()
            player2.attack(player1, guns.random())
            player1.health(medicine[(Math.random() * medicine.size).toInt()])

            println("_".repeat(35))


        }
    }

    fun isFinish(): Boolean {

        var result = false

        if (player1.hp <= 10) {
            println("${player1.name} вбитий гравцем ${player2.name}")
            result = true

        } else if (player2.hp <= 10) {
            println("${player2.name} вбитий гравцем ${player1.name}")
            result = true
        }

        return result
    }
}