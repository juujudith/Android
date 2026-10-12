package com.judith.activitat03

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var peso = 170
    private var edad = 18
    private var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvAltura = findViewById<TextView>(R.id.tvAltura)
        val sliderAltura = findViewById<Slider>(R.id.sliderAltura)
        val tvPeso = findViewById<TextView>(R.id.tvPeso)
        val btnPesoMenos = findViewById<Button>(R.id.btnPesoMenos)
        val btnPesoMas = findViewById<Button>(R.id.btnPesoMas)
        val tvEdad = findViewById<TextView>(R.id.tvEdad)
        val btnEdadMenos = findViewById<Button>(R.id.btnEdadMenos)
        val btnEdadMas = findViewById<Button>(R.id.btnEdadMas)
        val cardMale = findViewById<CardView>(R.id.cardMale)
        val cardFemale = findViewById<CardView>(R.id.cardFemale)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // SLIDER
        sliderAltura.addOnChangeListener { _, value, _ ->
            tvAltura.text = value.toInt().toString()
        }

        // BOTONES DE PESO
        btnPesoMas.setOnClickListener {
            peso++
            tvPeso.text = peso.toString()
        }
        btnPesoMenos.setOnClickListener {
            peso--
            tvPeso.text = peso.toString()
        }

        // BOTONES DE EDAD
        btnEdadMas.setOnClickListener {
            edad++
            tvEdad.text = edad.toString()
        }
        btnEdadMenos.setOnClickListener {
            edad--
            tvEdad.text = edad.toString()
        }

        // TARJETAS MALE / FEMALE
        val colorActivo = Color.parseColor("#3F4175")
        val colorInactivo = Color.parseColor("#111328")

        cardMale.setOnClickListener {
            sexo = "MALE"
            cardMale.setCardBackgroundColor(colorActivo)
            cardFemale.setCardBackgroundColor(colorInactivo)
        }
        cardFemale.setOnClickListener {
            sexo = "FEMALE"
            cardFemale.setCardBackgroundColor(colorActivo)
            cardMale.setCardBackgroundColor(colorInactivo)
        }

        // BOTÓN CALCULATE
        btnCalcular.setOnClickListener {
            val altura = sliderAltura.value.toDouble()
            val imc = 703 * peso / (altura * altura)
            val intent = Intent(this, ResultatActivity::class.java)

            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }
}