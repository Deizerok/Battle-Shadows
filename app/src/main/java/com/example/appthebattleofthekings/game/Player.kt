package com.example.appthebattleofthekings.game


data class Player(
    var hp: Int = 100,
    var name: String = "",
    var gun: Gun,
    var medicine: Medicine
) {



    fun health(medicine: Medicine) {
        this.hp += medicine.health()
//        println("$name ($hp) захілявся ${medicine.name} на +(${medicine.hp})")
    }


    fun attack(player: Player, gun: Gun) {
        player.hp -= gun.damage()
//        println("$name ($hp) атакує ${player.name} (${player.hp}) зброєю ${gun.name} на -(${gun.hp})")
    }
}