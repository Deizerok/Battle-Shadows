package com.example.appthebattleofthekings

import android.app.Application
import com.example.appthebattleofthekings.main.GameViewModel
import com.example.appthebattleofthekings.main.LiveDataWrapper


class App: Application() {

    lateinit var gameViewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        gameViewModel = GameViewModel(LiveDataWrapper.Base())
    }
}