package com.lsakee.feature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lsakee.feature_compose.MainActivity
import timber.log.Timber

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, com.lsakee.feature.MainActivity::class.java))
//        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}