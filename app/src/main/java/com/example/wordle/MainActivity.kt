package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessButton : Button = findViewById(R.id.guess_button)
        guessButton.setOnClickListener{ checkInput() }

        val newGameButton : Button = findViewById(R.id.new_game)
        newGameButton.setOnClickListener { setNewGame() }
    }

    private var wordToGuess = getRandomFourLetterWord()

    private fun setNewGame() {
        // Set Variables
        val inputBox: EditText = findViewById(R.id.guess_input)
        val newGameButton: Button = findViewById(R.id.new_game)
        val guessButton: Button = findViewById(R.id.guess_button)
        val word: TextView = findViewById(R.id.word)

        // Guess TextViews
        val guess_1_1 : TextView = findViewById(R.id.guess_1_1)
        val guess_1_2 : TextView = findViewById(R.id.guess_1_2)
        val guess_2_1 : TextView = findViewById(R.id.guess_2_1)
        val guess_2_2 : TextView = findViewById(R.id.guess_2_2)
        val guess_3_1 : TextView = findViewById(R.id.guess_3_1)
        val guess_3_2 : TextView = findViewById(R.id.guess_3_2)

        // Answer TextViews
        val answer_1_1 : TextView = findViewById(R.id.answer_1_1)
        val answer_1_2 : TextView = findViewById(R.id.answer_1_2)
        val answer_2_1 : TextView = findViewById(R.id.answer_2_1)
        val answer_2_2 : TextView = findViewById(R.id.answer_2_2)
        val answer_3_1 : TextView = findViewById(R.id.answer_3_1)
        val answer_3_2 : TextView = findViewById(R.id.answer_3_2)

        // Change Guess TextViews
        guess_1_1.visibility = View.INVISIBLE
        guess_1_2.visibility = View.INVISIBLE
        guess_2_1.visibility = View.INVISIBLE
        guess_2_2.visibility = View.INVISIBLE
        guess_3_1.visibility = View.INVISIBLE
        guess_3_2.visibility = View.INVISIBLE

        // Change Answer TextViews
        answer_1_1.visibility = View.INVISIBLE
        answer_1_2.visibility = View.INVISIBLE
        answer_2_1.visibility = View.INVISIBLE
        answer_2_2.visibility = View.INVISIBLE
        answer_3_1.visibility = View.INVISIBLE
        answer_3_2.visibility = View.INVISIBLE

        word.visibility = View.INVISIBLE
        inputBox.visibility = View.VISIBLE
        guessButton.visibility = View.VISIBLE
        newGameButton.visibility = View.GONE
        wordToGuess = getRandomFourLetterWord()
    }

    private fun setEndGame(){
        // Set Variables
        val inputBox: EditText = findViewById(R.id.guess_input)
        val newGameButton: Button = findViewById(R.id.new_game)
        val guessButton: Button = findViewById(R.id.guess_button)
        val word: TextView = findViewById(R.id.word)

        word.text = wordToGuess
        word.visibility = View.VISIBLE
        inputBox.visibility = View.GONE
        guessButton.visibility = View.GONE
        newGameButton.visibility = View.VISIBLE
    }

    private fun checkInput(){
        // Set Variables
        val inputBox: EditText = findViewById(R.id.guess_input)
        val newGameButton: Button = findViewById(R.id.new_game)
        val guessButton: Button = findViewById(R.id.guess_button)
        val word: TextView = findViewById(R.id.word)
        val input = inputBox.text.toString()

        // Guess TextViews
        val guess_1_1 : TextView = findViewById(R.id.guess_1_1)
        val guess_1_2 : TextView = findViewById(R.id.guess_1_2)
        val guess_2_1 : TextView = findViewById(R.id.guess_2_1)
        val guess_2_2 : TextView = findViewById(R.id.guess_2_2)
        val guess_3_1 : TextView = findViewById(R.id.guess_3_1)
        val guess_3_2 : TextView = findViewById(R.id.guess_3_2)

        // Answer TextViews
        val answer_1_1 : TextView = findViewById(R.id.answer_1_1)
        val answer_1_2 : TextView = findViewById(R.id.answer_1_2)
        val answer_2_1 : TextView = findViewById(R.id.answer_2_1)
        val answer_2_2 : TextView = findViewById(R.id.answer_2_2)
        val answer_3_1 : TextView = findViewById(R.id.answer_3_1)
        val answer_3_2 : TextView = findViewById(R.id.answer_3_2)

        if (input.all{it.isLetter()}){
            if (input.length == 4){
                val result = checkGuess(input.uppercase())

                if (!guess_1_1.isVisible){
                    // Set first line visible
                    guess_1_1.isVisible = true
                    answer_1_1.text = input
                    answer_1_1.isVisible = true

                    // Set second line visible
                    guess_1_2.isVisible = true
                    answer_1_2.text = result
                    answer_1_2.isVisible = true

                    inputBox.text.clear()
                }
                else if (!guess_2_1.isVisible){
                    // Set third line visible
                    guess_2_1.isVisible = true
                    answer_2_1.text = input
                    answer_2_1.isVisible = true

                    // Set fourth line visible
                    guess_2_2.isVisible = true
                    answer_2_2.text = result
                    answer_2_2.isVisible = true

                    inputBox.text.clear()
                }
                else if (!guess_3_1.isVisible){
                    // Set fifth line visible
                    guess_3_1.isVisible = true
                    answer_3_1.text = input
                    answer_3_1.isVisible = true

                    // Set sixth line visible
                    guess_3_2.isVisible = true
                    answer_3_2.text = result
                    answer_3_2.isVisible = true

                    inputBox.text.clear()

                    word.text = wordToGuess
                    word.visibility = View.VISIBLE
                    inputBox.visibility = View.GONE
                    guessButton.visibility = View.GONE
                    newGameButton.visibility = View.VISIBLE
                }

                if (result == "OOOO"){
                    Toast.makeText(this, "Congratulations!", Toast.LENGTH_LONG).show()
                    setEndGame()
                }
            }
            else{
                inputBox.text.clear()
                Toast.makeText(this, "Please, only 4 letters.", Toast.LENGTH_LONG).show()
            }
        }
        else{
            inputBox.text.clear()
            Toast.makeText(this, "Word must be only letters.", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}