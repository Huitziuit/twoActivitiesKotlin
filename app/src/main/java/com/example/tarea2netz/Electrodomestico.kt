package com.example.tarea2netz

import java.io.Serializable

data class Electrodomestico (
    val nombre:String,
    val potencia: Int,
    val horas: Int,
    val conectado:String
        ):Serializable