package com.example.appthebattleofthekings.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.appthebattleofthekings.App
import com.example.appthebattleofthekings.R
import com.example.appthebattleofthekings.databinding.ActivityMainBinding
import com.example.appthebattleofthekings.game.Gun
import com.example.appthebattleofthekings.game.Medicine
import com.example.appthebattleofthekings.presentation.UiState

class MainActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextName = findViewById<EditText>(R.id.editTextText)

        gameViewModel = (application as App).gameViewModel


        binding.akButton.setOnClickListener {
            gameViewModel.chooseWeapon(Gun.AK)
        }

        binding.m4Button.setOnClickListener {
            gameViewModel.chooseWeapon(Gun.M4)
        }

        binding.awpButton.setOnClickListener {
            gameViewModel.chooseWeapon(Gun.Scout)
        }

        binding.pillsButton.setOnClickListener {
            gameViewModel.chooseMedicine(Medicine.Pills)
        }

        binding.energeticButton.setOnClickListener {
            gameViewModel.chooseMedicine(Medicine.Energetic)
        }

        binding.medKitButton.setOnClickListener {
            gameViewModel.chooseMedicine(Medicine.MedKid)
        }

        binding.goToResultButton.setOnClickListener {
            gameViewModel.goToResult()
        }
        binding.goToGameMenuButton.setOnClickListener {
            gameViewModel.goToGameMenu()
        }
        binding.playButton.setOnClickListener {
            gameViewModel.goToChooseWeapon()
        }

        binding.setNicknameButton.setOnClickListener {
            gameViewModel.goToChangeNickname()
        }


        binding.nextButton.setOnClickListener {
            gameViewModel.goToGameMenuAfterChangeNickname(editTextName.text.toString())
        }

        binding.rulesButton.setOnClickListener {
            gameViewModel.goToRules()
        }

        binding.closeGuideButton.setOnClickListener {
            gameViewModel.goToGameMenu()
        }

        gameViewModel.liveData().observe(this) {
            it.apply(binding)
        }



        gameViewModel.init(savedInstanceState)
    }
}