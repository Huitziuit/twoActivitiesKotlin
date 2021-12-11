package com.example.tarea2netz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class Lista_electronicos : AppCompatActivity() {

    val list = mutableListOf<Electrodomestico>() //el <User es redundante >
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_electronicos)

        var data = DataElectrodomesticos()
        var electrodomesticos = data.loadData(this)

        var totalE=electrodomesticos.total
        var message:String=""
        for (i in (1..totalE)){
            message+="${electrodomesticos.getElect(i).nombre }\n"
            message+="${electrodomesticos.getElect(i).potencia }\n"
            message+="${electrodomesticos.getElect(i).horas }\n"
            message+="${electrodomesticos.getElect(i).conectado }\n\n\n"
        }
        findViewById<TextView>(R.id.info).text = message


        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}