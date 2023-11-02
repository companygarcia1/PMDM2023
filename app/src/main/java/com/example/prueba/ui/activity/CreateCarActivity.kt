package com.example.prueba.ui.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.data.cars.Car
import com.example.prueba.data.DataSource
import com.example.prueba.databinding.ActivityCreateCarBinding

class CreateCarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        binding.btnAccepted.setOnClickListener {
            setResult(Activity.RESULT_OK)
            saveCar()
            finish()
        }
    }

    private fun saveCar() {
        var license = binding.editLicencia.editText?.text.toString()
        var model = binding.editModel.editText?.text.toString()
        var brand = binding.editBranch.editText?.text.toString()
        DataSource.dataSourceCars.saveCar(this, Car(license, model, brand))
    }
}