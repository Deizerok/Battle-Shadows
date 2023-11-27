package com.example.appthebattleofthekings

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private lateinit var linearLayoutChoose: LinearLayout
    private lateinit var linearLayoutMed: LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById<LinearLayout>(R.id.rootLayout)
        linearLayoutChoose = findViewById<LinearLayout>(R.id.choice)
        linearLayoutMed = findViewById<LinearLayout>(R.id.chooseMed)

        val medicine = arrayOf(
            Medicine("Tablet", 17),
            Medicine("Energetics", 19),
            Medicine("First aid kit", 23)
        )

        val guns = arrayOf(
            Gun("AK-47", 20),
            Gun("M4-A1", 21),
            Gun("AWP", 29)
        )


        linearLayoutChoose.visibility = View.GONE
        linearLayoutMed.visibility = View.INVISIBLE

        val version = findViewById<TextView>(R.id.Version)
        version.text = "Alpha Version: 0.N27"

        val akButton = findViewById<Button>(R.id.ak)
        val m4Button = findViewById<Button>(R.id.m4)
        val awpButton = findViewById<Button>(R.id.awp)

        val tabletButton = findViewById<Button>(R.id.tablet)
        val energeticButton = findViewById<Button>(R.id.energetic)
        val medButton = findViewById<Button>(R.id.med)


        val battleButton = findViewById<Button>(R.id.Battle) // Enter
        val buttonNext = findViewById<Button>(R.id.next)
        val buttonNextRound = findViewById<Button>(R.id.nextRound)
        val buttonAfterMedicine = findViewById<Button>(R.id.buttonAfterMedicine)
        val shortMatch = findViewById<Button>(R.id.shortMatch)

        var numberRound: Int = 0

        shortMatch.visibility = View.GONE
        buttonNext.visibility = View.GONE
        battleButton.visibility = View.VISIBLE
        buttonAfterMedicine.visibility = View.GONE

        val text = findViewById<TextView>(R.id.TextHello)
        val text1 = findViewById<TextView>(R.id.TextHello1)
        val textRound = findViewById<TextView>(R.id.textRound)

        text1.visibility = View.GONE
        textRound.visibility = View.GONE
        buttonNextRound.visibility = View.INVISIBLE


        var name = findViewById<EditText>(R.id.editTextText)

        var player01 = Player(name = "")
        var Bot01 = Player(name = "Bot04")


        buttonAfterMedicine.setOnClickListener {
            buttonAfterMedicine.visibility = View.GONE
            text1.visibility = View.INVISIBLE
            buttonNext.visibility = View.GONE
            battleButton.visibility = View.GONE
            linearLayoutChoose.visibility = View.VISIBLE
            text.setText("Choose your weapon.")

        }
        buttonNextRound.setOnClickListener {
            textRound.visibility = View.GONE
            name.visibility = View.GONE
            player01.name = name.text.toString()
            buttonNext.visibility = View.GONE
            battleButton.visibility = View.GONE
            linearLayoutMed.visibility = View.VISIBLE
            linearLayoutChoose.visibility = View.GONE
            text.setText("Choose your medicine.")
            buttonNextRound.visibility = View.GONE
            text1.visibility = View.GONE
        }

        buttonNext.setOnClickListener {
            shortMatch.visibility = View.GONE
            buttonNext.visibility = View.GONE
            name.visibility = View.INVISIBLE
            player01.name = name.text.toString()
            buttonNext.visibility = View.GONE
            battleButton.visibility = View.GONE
            linearLayoutChoose.visibility = View.VISIBLE
            text.setText("Choose your weapon.")
        }

        battleButton.setOnClickListener {
//            linearLayoutChoose.visibility = View.VISIBLE
            shortMatch.visibility = View.VISIBLE
            name.visibility = View.INVISIBLE
            player01.name = name.text.toString()
            battleButton.visibility = View.INVISIBLE
            buttonNext.visibility = View.VISIBLE
            text.setText("Looking for a battle?")
            buttonNext.setText("1.Long match!")


        }
        shortMatch.setOnClickListener {
            shortMatch.visibility = View.GONE
            buttonNext.visibility = View.GONE
        }

        tabletButton.setOnClickListener {
            buttonNext.visibility = View.INVISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            buttonAfterMedicine.visibility = View.VISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            linearLayoutMed.visibility = View.GONE

            linearLayoutChoose.visibility = View.GONE
            linearLayoutMed.visibility = View.GONE

            player01.health(medicine[0])
            text.setText("Player: <You> ${player01.name} healed point:${medicine[0]} the current moment of the health point: ${player01.hp}")
            text1.visibility = View.VISIBLE
            val medicineBot = medicine[(Math.random() * guns.size).toInt()]
            Bot01.health(medicineBot)
            text1.text =
                "Player: ${Bot01.name} healed point:${medicineBot} the current moment of the health point: ${Bot01.hp}"


        }
        energeticButton.setOnClickListener {
            buttonNext.visibility = View.INVISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            buttonAfterMedicine.visibility = View.VISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            linearLayoutMed.visibility = View.GONE

            linearLayoutChoose.visibility = View.GONE
            linearLayoutMed.visibility = View.GONE

            player01.health(medicine[1])
            text.setText("Player: <You> ${player01.name} healed point:${medicine[1]} the current moment of the health point: ${player01.hp}")
            text1.visibility = View.VISIBLE
            val medicineBot = medicine[(Math.random() * guns.size).toInt()]
            Bot01.health(medicineBot)
            text1.text =
                "Player: ${Bot01.name} healed point:${medicineBot} the current moment of the health point: ${Bot01.hp}"


        }

        medButton.setOnClickListener {
            buttonNext.visibility = View.INVISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            buttonAfterMedicine.visibility = View.VISIBLE
            buttonNextRound.visibility = View.INVISIBLE
            linearLayoutMed.visibility = View.GONE

            linearLayoutChoose.visibility = View.GONE
            linearLayoutMed.visibility = View.GONE

            player01.health(medicine[2])
            text.setText("Player: <You> ${player01.name} healed point:${medicine[2]} the current moment of the health point: ${player01.hp}")
            text1.visibility = View.VISIBLE
            val medicineBot = medicine[(Math.random() * guns.size).toInt()]
            Bot01.health(medicineBot)
            text1.text =
                "Player: ${Bot01.name} healed point:${medicineBot} the current moment of the health point: ${Bot01.hp}"


        }

        //Med>


        akButton.setOnClickListener {
            val battle = Battle(player01, Bot01)
            textRound.visibility = View.VISIBLE
            battle.play()
            buttonNext.visibility = View.INVISIBLE

            linearLayoutChoose.visibility = View.GONE
            player01.attack(Bot01, guns[0])

            textRound.setText("Round: ${++numberRound}")
            text.setText("Player: ${player01.name} health point:${player01.hp}  attacked: ${Bot01.name} with this weapon:${guns[0]}")

            text1.visibility = View.VISIBLE
            val gunBot = guns[(Math.random() * guns.size).toInt()]
            Bot01.attack(player01, gunBot)
            text1.text =
                "Player: ${Bot01.name} health point:${Bot01.hp} attacked: ${player01.name} with this weapon:${gunBot}"

            buttonNextRound.text = "Next Round"
            buttonNextRound.visibility = View.VISIBLE

        }
        m4Button.setOnClickListener {
            val battle = Battle(player01, Bot01)
            textRound.visibility = View.VISIBLE
            battle.play()
            buttonNext.visibility = View.INVISIBLE

            linearLayoutChoose.visibility = View.GONE
            player01.attack(Bot01, guns[1])

            textRound.setText("Round: ${++numberRound}")
            text.setText("Player: ${player01.name} health point:${player01.hp}  attacked: ${Bot01.name} with this weapon:${guns[1]}")

            text1.visibility = View.VISIBLE
            val gunBot = guns[(Math.random() * guns.size).toInt()]
            Bot01.attack(player01, gunBot)
            text1.text =
                "Player: ${Bot01.name} health point:${Bot01.hp} attacked: ${player01.name} with this weapon:${gunBot}"

            buttonNextRound.text = "Next Round"
            buttonNextRound.visibility = View.VISIBLE
        }
        awpButton.setOnClickListener {
            val battle = Battle(player01, Bot01)
            textRound.visibility = View.VISIBLE
            battle.play()
            buttonNext.visibility = View.INVISIBLE

            linearLayoutChoose.visibility = View.GONE
            player01.attack(Bot01, guns[2])

            textRound.setText("Round: ${++numberRound}")
            text.setText("Player: ${player01.name} health point:${player01.hp}  attacked: ${Bot01.name} with this weapon:${guns[2]}")

            text1.visibility = View.VISIBLE
            val gunBot = guns[(Math.random() * guns.size).toInt()]
            Bot01.attack(player01, gunBot)
            text1.text =
                "Player: ${Bot01.name} health point:${Bot01.hp} attacked: ${player01.name} with this weapon:${gunBot}"

            buttonNextRound.text = "Next Round"
            buttonNextRound.visibility = View.VISIBLE
        }
    }
}
