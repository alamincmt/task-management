package com.example.taskmangement.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import com.example.taskmangement.R
import java.util.*

class SplashScreen : AppCompatActivity() {


    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        handler.postDelayed(3000) {
            var intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}



