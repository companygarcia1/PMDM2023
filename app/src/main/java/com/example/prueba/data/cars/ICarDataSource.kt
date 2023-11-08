package com.example.prueba.data.cars

import android.content.Context

interface ICarDataSource {
    suspend fun getCarsAsync(context: Context): ArrayList<Car>
    fun getCars(context: Context): ArrayList<Car>
    fun saveCar(context: Context,car: Car)
    fun deleteCar(context: Context,car: Car)
}