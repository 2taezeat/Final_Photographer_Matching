package com.example.final_photographer_matching.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.utils.StartActivityUtil

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mHandler = Handler(Looper.getMainLooper())
        mHandler.postDelayed({
            StartActivityUtil.callActivity(this@SplashActivity, MainActivity())
            finish()
        }, 2000)

    }

}