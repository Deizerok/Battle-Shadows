package com.example.appthebattleofthekings.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appthebattleofthekings.presentation.UiState

interface LiveDataWrapper {

    fun updateUi(uiState: UiState)

    fun liveDate(): LiveData<UiState>

    class Base : LiveDataWrapper {

        private val liveData = MutableLiveData<UiState>()

        override fun updateUi(uiState: UiState) {
            liveData.value = uiState
        }

        override fun liveDate() = liveData
    }
}