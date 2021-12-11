package com.example.tarea2netz

class Electrodomesticos {

    var total:Int=0;
    val list = mutableListOf<Electrodomestico>()

    fun add(electrodomestico: Electrodomestico){
        list.add(electrodomestico)
        total++
    }

    fun getElect(index: Int):Electrodomestico{
        return list[index]
    }
}