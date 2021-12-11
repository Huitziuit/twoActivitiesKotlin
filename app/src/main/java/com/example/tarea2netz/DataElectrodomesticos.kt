package com.example.tarea2netz

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson


class DataElectrodomesticos {

    val key = "OBJ"

    fun saveData(electrodomestico: Electrodomestico, con: Context){
        var electrodomesticosSave=loadData(con)
        if(electrodomesticosSave==null) {
            var electrodomesticos=Electrodomesticos()
            electrodomesticos.add(electrodomestico)
            val jsonString = Gson().toJson(electrodomesticos)

            val pref = PreferenceManager.getDefaultSharedPreferences(con)
            var editor = pref.edit()
            editor.putString(key, jsonString)
            editor.apply()
        }else{
            electrodomesticosSave.add(electrodomestico)
            val jsonString = Gson().toJson(electrodomesticosSave)

            val pref = PreferenceManager.getDefaultSharedPreferences(con)
            var editor = pref.edit()
            editor.putString(key, jsonString)
            editor.apply()
        }

    }

    fun loadData( con: Context): Electrodomesticos {

        val pref=PreferenceManager.getDefaultSharedPreferences(con)
        val jsonString = pref.getString(key, null)
        val auxElectrodomesticos = Gson().fromJson(jsonString,Electrodomesticos::class.java)

        return auxElectrodomesticos
    }

}