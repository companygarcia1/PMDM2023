package com.example.prueba.data

import com.example.prueba.data.cars.CarDataSourceFile
import com.example.prueba.data.cars.ICarDataSource

object DataSource {
    val dataSourceCars: ICarDataSource = CarDataSourceFile

}