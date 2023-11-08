package com.example.prueba.data.cars
import android.app.Activity
import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

object CarDataSourceFile : ICarDataSource {
    val fileName="cars.json"

    override suspend fun getCarsAsync(context: Context): ArrayList<Car>{
        return readFromFile(context)
    }

    override fun getCars(context: Context): ArrayList<Car> {
        return readFromFile(context)
    }

    override fun saveCar(context: Context,car : Car){
        val cars = readFromFile(context)
        cars.add(car)
        saveToFile(context,cars)
    }
    override fun deleteCar(context: Context,car : Car){
        val cars = readFromFile(context)
        cars.remove(car)
        saveToFile(context,cars)
    }

    fun getFile(context: Context):File{
        val carsFile = File(context.filesDir,fileName)
        if (!carsFile.exists()) {
            try {
                carsFile.createNewFile()
                println("El archivo se ha creado correctamente.")
            } catch (e: Exception) {
                println("Error al crear el archivo: ${e.message}")
            }
        } else {
            println("El archivo ya existe.")
        }
        return carsFile
    }
    fun saveToFile(context: Context,cars: List<Car>) {
        val carsFile = getFile(context)
        if (carsFile.exists()) {
            val writer = BufferedWriter(FileWriter(carsFile))
            cars.forEach { car ->
                writer.write("${car.license};${car.model};${car.brand}\n")
            }
            writer.close()
        }
    }

    private fun readFromFile(context: Context): ArrayList<Car> {
        val carsFile = getFile(context)
        val cars = ArrayList<Car>()
        if (carsFile.exists()) {
            val reader = BufferedReader(FileReader(carsFile))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val parts = line!!.split(";")
                if (parts.size == 3) {
                    val car = Car(parts[0], parts[1], parts[2])
                    cars.add(car)
                }
            }
            reader.close()
        }
        return cars
    }
}