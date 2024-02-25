package com.example.appthebattleofthekings.game

import android.widget.Button

interface Medicine {

    fun setButton(button: Button)

    fun health():Int


    abstract class Abstract(val name: String, val upHealth: Int) : Medicine {
        override fun setButton(button: Button) {
            button.text = name
        }

        override fun health(): Int {
            return upHealth
        }

        override fun toString(): String {
            return "Medicine:$name , Health:$upHealth"

        }
    }

    object Pills : Abstract(name = "Pills", upHealth = 17)

    object Energetic : Abstract(name = "Energetic", upHealth = 19)

    object MedKid : Abstract(name = "MedKid", upHealth = 23)
}

