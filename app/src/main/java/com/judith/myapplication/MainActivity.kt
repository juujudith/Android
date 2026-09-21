package com.judith.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("hola")

        // 21/09/2026

        // 1. Tipus automàtics
        fun longitud(obj: Any): Int? {
            if (obj is String) {
                return obj.length   // aquí obj ja és un String
            }
            return null
        }

        // 2.


        // 3. Mutabilitat de les variables
        val x = 5
        var c = 10

        // 4. Null Safety
        var nom: String? = "Judith"
        nom = null

        // 5. if, when, try
        val nomProfe = "Toni"
        val text =  if (nomProfe == "Toni") "Ets el professor d'Android" else "No ets el professor d'Android"


        val nomDia = when (dia) {
            1 -> "Dilluns"
            2 -> "Dimarts"
            3 -> "Dimecres"
            4 -> "Dijous"
            5 -> "Divendres"
            else -> "Cap de setmana"
        }

        val resultat = try {
            10 / 0
        } catch (e: ArithmeticException) {
            0
        }

        // 6. Valor Unit


        // 7. Funcions lambda


        // 8. Col·leccions immutables i mutables

    }
}