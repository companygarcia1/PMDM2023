package com.example.prueba.ui.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.data.Car
import com.example.prueba.data.CarDataSource
import com.example.prueba.databinding.ActivityCreateCarBinding
class CreateCarActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCreateCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener(){
        binding.btnAccepted.setOnClickListener {
            setResult(Activity.RESULT_OK)
            CarDataSource.saveCar(Car("nuevo_coche","modelo","brand"))
            finish()
        }
        binding.btnCancelled.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}