package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var pressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            if (enterNameEditText.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name !", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizCategories::class.java)
                //start intent by passing intent
                //passing data to next activity
                //passed key value pair for recognition
                intent.putExtra("user", enterNameEditText.text.toString())
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

}

