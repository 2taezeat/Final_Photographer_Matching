package com.example.final_photographer_matching.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class StartActivityUtil() {

    companion object {
        fun callActivity(fromActivity: AppCompatActivity, toActivity: AppCompatActivity) {
            val intent = Intent(fromActivity, toActivity::class.java)
            startActivity(fromActivity, intent, null)
        }

    }
}

