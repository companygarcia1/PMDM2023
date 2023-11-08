package com.example.prueba.data.cars

import android.content.Context

object CarDataSourceList : ICarDataSource {
    private val cars = ArrayList<Car>()
    init{
        cars.add(Car("3456DFC", "BMW", "320CD"))
        cars.add(Car("2314FCT", "BMW", "320CD"))
        cars.add(Car("2967TRW", "BMW", "320CD"))
    }
    override fun getCars(context: Context): ArrayList<Car> {
        return cars
    }
    override fun saveCar(context: Context,car : Car){
        cars.add(car)
    }
    override fun deleteCar(context: Context,car : Car){
        cars.remove(car)
    }

    override suspend fun getCarsAsync(context: Context): ArrayList<Car>{
        return cars
    }

}