package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.databinding.ActivityMainExample2Binding

class MainActivityExample2 : AppCompatActivity() {
    private lateinit var binding:ActivityMainExample2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setConfigView()
        setListener()
    }

    private fun setConfigView(){

    }

    private fun setListener(){

    }
}