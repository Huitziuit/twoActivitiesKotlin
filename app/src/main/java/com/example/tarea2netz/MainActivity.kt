package com.example.tarea2netz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val usersList = mutableListOf<String>() //el <User es redundante >

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btn_show_elec).setOnClickListener {
            val nombre = findViewById<TextInputEditText>(R.id.nombre_elec).text.toString()
            val potencia = findViewById<TextInputEditText>(R.id.potencia_elec).text.toString().toInt()
            val horas = findViewById<TextInputEditText>(R.id.horas_elec).text.toString().toInt()
            val conectado = findViewById<CheckBox>(R.id.CB_siempre_conectado).isChecked.toString()
            val elect = Electrodomestico(nombre,potencia,horas,conectado)


            Intent(this, Lista_electronicos::class.java).also {
                /*it.putExtra("EXTRA_NAME",nombre)
                it.putExtra("EXTRA_POT", potencia)
                it.putExtra("EXTRA_HR", horas)
                it.putExtra("EXTRA_CN", conectado)*/
                it.putExtra("EXTRA_ELECT", elect)
                startActivity(it)
            }
        }
    }
}