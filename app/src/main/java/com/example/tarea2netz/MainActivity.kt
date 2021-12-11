package com.example.tarea2netz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    val usersList = mutableListOf<String>() //el <User es redundante >

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Provando list
/*
        var e1=Electrodomestico("radio",200,2,"true")
        var e2=Electrodomestico("Tv",400,5,"false")
        var e3=Electrodomestico("refri",8000,24,"true")

        var electrodomesticos=Electrodomesticos()
        electrodomesticos.add(e1)
        electrodomesticos.add(e2)
        electrodomesticos.add(e3)

        var data =DataElectrodomesticos()
        data.saveData(electrodomesticos,this)

        Log.i("elect","${electrodomesticos.getElect(0)}")
        Log.i("elect","${electrodomesticos.getElect(1)}")
        Log.i("elect","${electrodomesticos.getElect(2)}")


*/

        findViewById<MaterialButton>(R.id.btn_show_elec).setOnClickListener {
            val nombre = findViewById<TextInputEditText>(R.id.nombre_elec).text.toString()
            val potencia = findViewById<TextInputEditText>(R.id.potencia_elec).text.toString().toInt()
            val horas = findViewById<TextInputEditText>(R.id.horas_elec).text.toString().toInt()
            val conectado = findViewById<CheckBox>(R.id.CB_siempre_conectado).isChecked.toString()
            val newElect = Electrodomestico(nombre,potencia,horas,conectado)


            var data =DataElectrodomesticos()
            data.saveData(newElect,this)

            Intent(this, Lista_electronicos::class.java).also {
                startActivity(it)
            }
        }
    }
}