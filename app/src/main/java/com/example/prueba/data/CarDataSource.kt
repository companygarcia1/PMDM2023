package com.example.prueba.data

object CarDataSource {
    private val cars = ArrayList<Car>()
    init{
        cars.add(Car("3456DFC", "BMW", "320CD"))
        cars.add(Car("2314FCT", "BMW", "320CD"))
        cars.add(Car("2967TRW", "BMW", "320CD"))
    }
    fun getCars(): ArrayList<Car> {

        return cars
    }
    fun saveCar(car :Car){
        cars.add(car)
    }
    fun deleteCar(car :Car){
        cars.remove(car)
    }
}