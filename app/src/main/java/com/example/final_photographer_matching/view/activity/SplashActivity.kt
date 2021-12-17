package com.example.final_photographer_matching.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.utils.StartActivityUtil

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_splash)

        try {
            Thread.sleep(1400)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        StartActivityUtil.callActivity(this, MainActivity())
        finish()

    }
}