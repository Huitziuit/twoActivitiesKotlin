package com.example.tarea2netz


data class Electrodomestico (var nombre:String, val potencia: Int, val horas: Int, val conectado:String){
    fun getData():String{
        var gasto:Float;
        var info:String=""
        info+="Dispositivo: $nombre \n"
        info+="Potencia : $potencia W\n"
        info+="Horas de uso al dia: $horas \n"
        info+="Permanece conectado: $conectado \n"
        gasto=(potencia.toFloat()/1000)*30
        if(conectado=="true"){
            gasto=((10*gasto)/100)+gasto
        }
        val gastoRound:Double = String.format("%.3f", gasto).toDouble()
        info+="Gasto al mes: $gastoRound Kwh\n\n\n"

        return info
    }
}