package com.judith.activitat03

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvCategoria = findViewById<TextView>(R.id.tvCategoria)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)
        val btnRecalcular = findViewById<Button>(R.id.btnRecalcular)

        val imc = intent.getDoubleExtra("IMC", 0.0)

        val categoria: String
        val descripcion: String
        val color: String

        when {
            imc < 18.5 -> {
                categoria = "UNDERWEIGHT"
                descripcion = "Underweight"
                color = "#FFA726"   // naranja
            }
            imc < 25.0 -> {
                categoria = "NORMAL"
                descripcion = "Normal"
                color = "#24D876"   // verde
            }
            imc < 30.0 -> {
                categoria = "OVERWEIGHT"
                descripcion = "Overweight."
                color = "#FFA726"   // naranja
            }
            else -> {
                categoria = "OBESE"
                descripcion = "Obese"
                color = "#EB1555"   // rojo
            }
        }

        tvCategoria.text = categoria
        tvCategoria.setTextColor(Color.parseColor(color))
        tvResultado.text = String.format("%.2f", imc)   // 2 decimales
        tvDescripcion.text = descripcion

        btnRecalcular.setOnClickListener {
            finish()
        }
    }
}