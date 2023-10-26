package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba.R
import com.example.prueba.data.Car
import com.example.prueba.data.CarDataSource
import com.example.prueba.databinding.ActivityDetailVehicleBinding

class DetailVehicle : AppCompatActivity() {
    private lateinit var binding:ActivityDetailVehicleBinding
    private lateinit var car:Car
    companion object{
        val EXTRA_DATA:String="datagfugfudgiutd"
        val EXTRA_POSITION:String="position"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        setListener()
    }

    private fun setListener(){
        binding.btnDelete.setOnClickListener {
            CarDataSource.deleteCar(car)
            finish()
        }
    }
    private fun setData(){
        val message = intent.getStringExtra(EXTRA_DATA)
        val position = intent.getIntExtra(EXTRA_POSITION,0)
        val cars = CarDataSource.getCars()
        car = cars.get(position)
        binding.txtlicense.text = car.license
    }
}