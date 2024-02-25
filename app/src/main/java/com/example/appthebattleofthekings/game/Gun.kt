package com.example.appthebattleofthekings.game

import android.widget.Button

interface Gun {

    fun damage():Int

    fun setButton(button: Button)

    abstract class Abstract(val name:String, val damage: Int): Gun {

        override fun setButton(button: Button) {
            button.text = name
        }

        override fun damage(): Int {
            return damage
        }

        override fun toString(): String {
            return "Gun:$name Damage:$damage"
        }
    }

    object AK : Abstract("AK-47", 20)

    object M4 : Abstract("M4", 22)

    object Scout : Abstract("Scout", 29)
}

