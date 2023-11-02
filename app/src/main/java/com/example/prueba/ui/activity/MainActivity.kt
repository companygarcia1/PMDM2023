package com.example.prueba.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.prueba.data.cars.Car
import com.example.prueba.data.DataSource
import com.example.prueba.ui.adapters.CarAdapter
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    override fun onStart() {
        super.onStart()
        setData()
    }

    private fun setData() {
        adapter = CarAdapter(this, DataSource.dataSourceCars.getCars(this))
        binding.carList.adapter = adapter
        binding.carList.emptyView = binding.txtEmptyview
    }

    private fun setListener() {
        binding.carList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val vehicle: Car = binding.carList.getItemAtPosition(position) as Car
                Toast.makeText(
                    applicationContext,
                    "${vehicle.license}",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(this, DetailVehicleActivity::class.java)
                intent.putExtra(DetailVehicleActivity.EXTRA_DATA, "Hola mundo")
                intent.putExtra(DetailVehicleActivity.EXTRA_POSITION, position)
                startActivity(intent)
            }
        binding.button2.setOnClickListener {
            val intent = Intent(this, CreateCarActivity::class.java)
            startActivityForResult(intent, 1234)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234) {
            if (resultCode == Activity.RESULT_OK) {
                adapter.setData(DataSource.dataSourceCars.getCars(this))
                adapter.notifyDataSetChanged()
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}