package com.studentwk4.randomguess

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//test1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get random number 1-100000
        var number = ((Math.random() * 100001) + 1).toInt()
        //Get random number 0-100000
        //var number = (Math.random () * 100001) .toInt()
        //Toast is an easy way to alert user. Shows up on bottom of app
        Toast.makeText(this, "Number to remember: ${number}", Toast.LENGTH_LONG).show()

        val txtGuess = findViewById<EditText>(R.id.txtGuess)
        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnToast = findViewById<Button>(R.id.btnToast)
        btnGuess.setOnClickListener {
            if (number == txtGuess.text.toString().toInt()) {
                Toast.makeText(this, "Correct, Great Job Remembering!", Toast.LENGTH_LONG).show()
                txtGuess.setText("")
            } else {
                Toast.makeText(this, "InCorrect, sorry but it's not the number that was shown.", Toast.LENGTH_LONG).show()
                txtGuess.setText("")
            }
            hideKeyboard()
        }
        btnToast.setOnClickListener {
            number = ((Math.random() * 100001) + 1).toInt()
            Toast.makeText(this, "Number to remember: ${number}", Toast.LENGTH_LONG).show()
        }
    }

    // function to hide keyboard goes right before the last right bracket of Class MainActivity
    //import android.content.Context
    //import android.view.inputmethod.InputMethodManager
    private fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}
