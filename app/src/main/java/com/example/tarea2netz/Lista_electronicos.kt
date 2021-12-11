package com.example.tarea2netz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Lista_electronicos : AppCompatActivity() {

    val list = mutableListOf<String>() //el <User es redundante >
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_electronicos)

        /*var name = intent.getStringExtra("EXTRA_NAME")
        var pot = intent.getIntExtra("EXTRA_POT", 0)
        var hr = intent.getIntExtra("EXTRA_HR", 0)
        var cn = intent.getStringExtra("EXTRA_CN")*/
        //var info= "$name use $pot W por $hr y esta conectado = $cn"
        //findViewById<TextView>(R.id.info).text = info

        var elect = intent.getSerializableExtra("EXTRA_ELECT") as electrodomestico

        list.add(elect.nombre)
        //list.add(info)
        findViewById<TextView>(R.id.info).text = list.toString()

        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            list.add(elect.nombre)
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}