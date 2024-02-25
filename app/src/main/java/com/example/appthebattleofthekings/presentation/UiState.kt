package com.example.appthebattleofthekings.presentation

import android.view.View
import com.example.appthebattleofthekings.databinding.ActivityMainBinding
import com.example.appthebattleofthekings.game.Gun
import com.example.appthebattleofthekings.game.Medicine
import com.example.appthebattleofthekings.game.Player
import java.io.Serializable

interface UiState : Serializable {

    fun apply(binding: ActivityMainBinding)

    object GameMenu : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            rulesLayout.visibility = View.GONE
            menuLayout.visibility = View.VISIBLE
            resultLayout.visibility = View.GONE
            choiceWeaponLayout.visibility = View.GONE
            chooseMedLayout.visibility = View.GONE
            changeNicknameLayout.visibility = View.GONE
        }
    }

    object ChangeNickname : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            menuLayout.visibility = View.GONE
            resultLayout.visibility = View.GONE
            changeNicknameLayout.visibility = View.VISIBLE
            helloTextView.text = "Enter your nickname!"
        }
    }

    object ChoiceWeapon : UiState {
        private val guns = listOf<Gun>(Gun.AK, Gun.M4, Gun.Scout)

        override fun apply(binding: ActivityMainBinding) = with(binding) {
            menuLayout.visibility = View.GONE
            choiceWeaponLayout.visibility = View.VISIBLE
            choiceWeaponTextView.text = "Time to choose a weapon"
            listOf(akButton, m4Button, awpButton).forEachIndexed { index, button ->
                guns[index].setButton(button)
            }
        }
    }

    object ChoiceMedicine : UiState {

        private val medicines =
            listOf<Medicine>(Medicine.Pills, Medicine.Energetic, Medicine.MedKid)

        override fun apply(binding: ActivityMainBinding) = with(binding) {
            chooseMedLayout.visibility = View.VISIBLE
            choiceWeaponLayout.visibility = View.GONE
            textMedicine.text = "Time to choose a medicine"
            listOf(pillsButton, energeticButton, medKitButton).forEachIndexed { index, button ->
                medicines[index].setButton(button)
            }
        }
    }

    object Guide : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            rulesLayout.visibility = View.VISIBLE
            menuLayout.visibility = View.GONE
        }

    }

    class Game(
        private val playerFirst: Player,
        private val playerTwo: Player
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            menuLayout.visibility = View.GONE
            chooseMedLayout.visibility = View.GONE
            choiceWeaponLayout.visibility = View.GONE
            goToResultButton.visibility = View.GONE
            goToResultButton.visibility = View.VISIBLE
            battleLayout.visibility = View.VISIBLE


            nameOneTextView.text = "Name:${playerFirst.name}"
            healthOneTextView.text = "Health Point:${playerFirst.hp.toString()}"
            gunOneTextView.text = playerFirst.gun.toString()

            nameTwoTextView.text = "Name:${playerTwo.name}"
            healthTwoTextView.text = "Health Point:${playerTwo.hp.toString()}"
            gunTwoTextView.text = playerTwo.gun.toString()
        }
    }

    class GameEnd(
        private val playerFirst: Player,
        private val playerTwo: Player
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            menuLayout.visibility = View.GONE
            chooseMedLayout.visibility = View.GONE
            choiceWeaponLayout.visibility = View.GONE
            goToResultButton.visibility = View.VISIBLE
            battleLayout.visibility = View.VISIBLE

            nameOneTextView.text = "Name:${playerFirst.name}"
            healthOneTextView.text = "Health Point:${playerFirst.hp.toString()}"
            gunOneTextView.text = playerFirst.gun.toString()

            nameTwoTextView.text = "Name:${playerTwo.name}"
            healthTwoTextView.text = "Health Point:${playerTwo.hp.toString()}"
            gunTwoTextView.text = playerTwo.gun.toString()

            goToResultButton.visibility = View.VISIBLE
        }
    }

    class GameResult(
        private val winner: String,
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) = with(binding) {
            menuLayout.visibility = View.GONE
            chooseMedLayout.visibility = View.GONE
            choiceWeaponLayout.visibility = View.GONE
            goToResultButton.visibility = View.GONE
            battleLayout.visibility = View.GONE
            resultLayout.visibility = View.VISIBLE

            winnerTextView.text = winner
            goToGameMenuButton.visibility = View.VISIBLE
        }
    }
}