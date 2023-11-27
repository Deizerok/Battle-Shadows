package com.example.appthebattleofthekings


data class Player(
    var hp: Int = 100,
    var name: String = ""
)
{



    fun health(medicine: Medicine) {
        this.hp += medicine.hp
        println("$name ($hp) захілявся ${medicine.name} на +(${medicine.hp})")

    }


    fun attack(player: Player, gun: Gun) {

        player.hp -= gun.hp
        println("$name ($hp) атакує ${player.name} (${player.hp}) зброєю ${gun.name} на -(${gun.hp})")

    }

    fun isFinish(player1:Player , player2:Player): Boolean {

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