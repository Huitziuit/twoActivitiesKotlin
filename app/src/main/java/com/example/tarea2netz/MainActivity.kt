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


        findViewById<MaterialButton>(R.id.btn_load_elec).setOnClickListener {
            val nombre = findViewById<TextInputEditText>(R.id.nombre_elec).text.toString()
            val potencia = findViewById<TextInputEditText>(R.id.potencia_elec).text.toString().toInt()
            val horas = findViewById<TextInputEditText>(R.id.horas_elec).text.toString().toInt()
            val conectado = findViewById<CheckBox>(R.id.CB_siempre_conectado).isChecked.toString()
            val newElect = Electrodomestico(nombre,potencia,horas,conectado)

            var data =DataElectrodomesticos()
            data.saveData(newElect,this)
        }

        findViewById<MaterialButton>(R.id.btn_show_elec).setOnClickListener {
            Intent(this, Lista_electronicos::class.java).also {
                startActivity(it)
            }
        }
    }
}