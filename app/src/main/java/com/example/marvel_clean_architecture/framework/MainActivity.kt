package com.example.marvel_clean_architecture.framework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel_clean_architecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}