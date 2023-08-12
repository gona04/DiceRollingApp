package com.example.dicerollingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicerollingapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Declare a binding variable using View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listeners for the buttons
        setupClickListeners()
    }

    // Function to set up click listeners for buttons
    private fun setupClickListeners() {
        // Click listener for rolling the dice once
        binding.rollButton.setOnClickListener {
            rollDice()
        }

        // Click listener for rolling the dice twice
        binding.rollTwiceButton.setOnClickListener {
            rollDiceTwice()
        }
    }

    // Function to roll a single die and display the result
    private fun rollDice() {
        // Get the ID of the selected radio button (selected dice type)
        val selectedDice = binding.diceRadioGroup.checkedRadioButtonId

        // Determine the maximum value of the selected dice
        val maxVal = when (selectedDice) {
            binding.radio4.id -> 4
            // Add cases for other dice types here
            else -> 6
        }

        // Generate a random result between 1 and maxVal (inclusive)
        val result = Random.nextInt(1, maxVal + 1)

        // Display the result in the TextView
        binding.resultTextView.text = "Result: $result"
    }

    // Function to roll two dice and display their results
    private fun rollDiceTwice() {
        // Get the ID of the selected radio button (selected dice type)
        val selectedDice = binding.diceRadioGroup.checkedRadioButtonId

        // Determine the maximum value of the selected dice
        val maxVal = when (selectedDice) {
            binding.radio4.id -> 4
            // Add cases for other dice types here
            else -> 6
        }

        // Generate random results for two dice rolls
        val result1 = Random.nextInt(1, maxVal + 1)
        val result2 = Random.nextInt(1, maxVal + 1)

        // Display the results in the TextView
        binding.resultTextView.text = "Results: $result1, $result2"
    }
}