package com.mentorq.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mentorq.R
import org.jetbrains.anko.startActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttonGetStarted = findViewById<Button>(R.id.get_started)

        buttonGetStarted.setOnClickListener {
            startActivity<MainActivity>()
        }

    }
}
