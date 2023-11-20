package com.example.prueba.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.example.prueba.R
import com.example.prueba.data.DataSource
import com.example.prueba.data.cars.Car
import com.example.prueba.databinding.ActivityMainBinding
import com.example.prueba.ui.activity.CreateCarActivity
import com.example.prueba.ui.activity.DetailVehicleActivity
import com.example.prueba.ui.adapters.CarAdapterAsync


class ListFragment : Fragment() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarAdapterAsync
    private lateinit var ctx: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        setData()
    }

    private fun configView() {
        adapter = CarAdapterAsync(ctx)
        binding.carList.adapter = adapter
        binding.carList.emptyView = binding.txtEmptyview
        binding.txtEmptyview.setText(R.string.search_cars)
    }

    private fun setData() {
        val cars = DataSource.dataSourceCars.getCars(ctx)
        adapter.setData(cars)
        if (cars.size == 0) {
            binding.txtEmptyview.setText(R.string.empty_cars)
        }
    }

    private fun setListener() {
        binding.carList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

            }
        binding.button2.setOnClickListener {

        }
    }
}