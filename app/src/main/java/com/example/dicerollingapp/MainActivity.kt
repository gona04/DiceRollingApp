package com.example.dicerollingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicerollingapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollDice()
        }

        binding.rollTwiceButton.setOnClickListener {
            rollDiceTwice()
        }
    }

    private fun rollDice() {
        val selectedDice = binding.diceRadioGroup.checkedRadioButtonId
        val maxVal = when (selectedDice) {
            binding.radio4.id -> 4
            // Add cases for other dice
            else -> 6
        }

        val result = Random.nextInt(1, maxVal + 1)
        binding.resultTextView.text = "Result: $result"
    }

    private fun rollDiceTwice() {
        val selectedDice = binding.diceRadioGroup.checkedRadioButtonId
        val maxVal = when (selectedDice) {
            binding.radio4.id -> 4
            // Add cases for other dice
            else -> 6
        }

        val result1 = Random.nextInt(1, maxVal + 1)
        val result2 = Random.nextInt(1, maxVal + 1)

        binding.resultTextView.text = "Results: $result1, $result2"
    }
}