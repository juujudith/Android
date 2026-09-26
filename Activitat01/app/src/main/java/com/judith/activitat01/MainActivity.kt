package com.judith.activitat01

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

        botDeSeguretat()
    }

    fun botDeSeguretat() {
        val judith = Persona("Judith", 29, listOf("videojocs", "anime"))

        if (judith.name != "Judith") {
            println("Error")
            return
        } else {
            println("Èxit")
        }

        val msg = if (judith.age <= 13 && judith.age >= 0) "Accés denegat"
                    else if (judith.age <= 17 && judith.age >= 14) "Necessites permís parental"
                    else "Èxit"

        println(msg)

        val entretenimentsOrdenats = judith.entreteniments.sorted()

        for (hobby in entretenimentsOrdenats) {
            if (hobby.first() in 'a' .. 'l')
                println(hobby)
        }
    }
}

data class Persona(val name: String, val age: Int, val entreteniments: List<String>)