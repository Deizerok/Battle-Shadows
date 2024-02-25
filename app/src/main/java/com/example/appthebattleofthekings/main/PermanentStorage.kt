package com.example.appthebattleofthekings.main

import android.content.Context

interface PermanentStorage {

    class Base(context: Context) : PermanentStorage {
        private val sharedPref =
            context.getSharedPreferences("quizGameStorage", Context.MODE_PRIVATE)
    }
}