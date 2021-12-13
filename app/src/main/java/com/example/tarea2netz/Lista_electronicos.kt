package com.example.tarea2netz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class Lista_electronicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_electronicos)

        var data = DataElectrodomesticos()
        var electrodomesticos = data.loadData(this)

        var message:String=""
        for (i in (1..electrodomesticos.total)){
            message+=electrodomesticos.getElect(i-1).getData()
        }

        findViewById<TextView>(R.id.info).text = message

        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}