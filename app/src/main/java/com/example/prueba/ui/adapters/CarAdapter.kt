package com.example.prueba.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.prueba.data.cars.Car
import com.example.prueba.databinding.CarAdapterItemBinding

class CarAdapter() : BaseAdapter() {
    private lateinit var context: Context
    private lateinit var list :ArrayList<Car>

    constructor( context: Context, list :ArrayList<Car>) : this() {
        this.context = context
        this.list = list
    }

    override fun getCount(): Int {
       return this.list.size
    }

    override fun getItem(position: Int): Any {
        return this.list[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.list[position]
         val inflator = context!!.getSystemService(
             Context.LAYOUT_INFLATER_SERVICE
                     ) as LayoutInflater
         val binding = CarAdapterItemBinding.inflate(inflator)

         binding.txtLicense.text = item.license
         binding.txtModel.text = item.model
         return binding.root
    }

    fun setData(cars: java.util.ArrayList<Car>) {
        this.list = cars
    }
}