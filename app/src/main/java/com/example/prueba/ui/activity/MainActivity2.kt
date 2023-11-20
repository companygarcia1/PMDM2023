package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
        setData()
    }

    fun setListener(){

    }

    fun setData(){

    }
}