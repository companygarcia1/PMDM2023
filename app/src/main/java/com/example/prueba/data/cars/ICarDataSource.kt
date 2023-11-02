package com.example.prueba.data.cars

import android.content.Context

interface ICarDataSource {
    fun getCars(context: Context): ArrayList<Car>
    fun saveCar(context: Context,car: Car)
    fun deleteCar(context: Context,car: Car)
}