package com.example.prueba.data.cars

data class Car(val license: String, val model: String, val brand: String) : Vehicle(license){
    override fun  toString():String{
        return "{$license};{$model}:{$brand}"
    }
}
