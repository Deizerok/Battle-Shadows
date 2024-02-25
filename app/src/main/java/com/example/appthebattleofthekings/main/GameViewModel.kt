package com.example.appthebattleofthekings.main

import android.os.Bundle
import com.example.appthebattleofthekings.game.Gun
import com.example.appthebattleofthekings.game.Medicine
import com.example.appthebattleofthekings.game.Player
import com.example.appthebattleofthekings.presentation.GameLogic
import com.example.appthebattleofthekings.presentation.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GameViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val medicines: List<Medicine> = listOf<Medicine>(
        Medicine.Pills,
        Medicine.Energetic,
        Medicine.MedKid
    ),
    private val guns: List<Gun> = arrayListOf<Gun>(Gun.AK, Gun.M4, Gun.Scout),
    private val player: Player = Player(name = "You", gun = Gun.AK, medicine = Medicine.Pills),
    private val bot: Player = Player(
        name = "Bot04",
        gun = guns[(Math.random() * guns.size).toInt()],
        medicine = medicines[(Math.random() * medicines.size).toInt()]
    ),
    private val gameLogic: GameLogic = GameLogic.Base(player, bot),
) {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var job: Job? = null

    fun liveData() = liveDataWrapper.liveDate()

    fun battle() {
        var history: String = ""

        liveDataWrapper.updateUi(UiState.Game(player, bot))

        job = viewModelScope.launch(Dispatchers.IO) {
            while (gameLogic.isNotFinish()) {
                gameLogic.attack()
                Thread.sleep(1000)
                withContext(Dispatchers.Main) {
                    liveDataWrapper.updateUi(UiState.Game(player, bot))
                }
            }
            withContext(Dispatchers.Main) {
                liveDataWrapper.updateUi(UiState.GameEnd(player, bot))
            }
        }

    }

    fun goToGameMenuAfterChangeNickname(name: String) {
        player.name = name
        liveDataWrapper.updateUi(UiState.GameMenu)
    }


    fun goToChooseWeapon() {
        liveDataWrapper.updateUi(UiState.ChoiceWeapon)
    }

    fun goToGameMenu() {
        job?.cancel()
        liveDataWrapper.updateUi(UiState.GameMenu)
    }

    fun chooseWeapon(weapon: Gun) {
        player.gun = weapon
        liveDataWrapper.updateUi(UiState.ChoiceMedicine)
    }

    fun chooseMedicine(medicine: Medicine) {
        player.medicine = medicine
        battle()
    }

    fun init(bundle: Bundle?) {
        if (bundle == null) {
            liveDataWrapper.updateUi(UiState.GameMenu)
        }
    }

    fun goToChangeNickname() {
        liveDataWrapper.updateUi(UiState.ChangeNickname)
    }

    fun goToRules() {
        liveDataWrapper.updateUi(UiState.Guide)
    }

    fun goToResult() {
        val winner = gameLogic.winner(player, bot)
        liveDataWrapper.updateUi(UiState.GameResult(winner))

    }
}

