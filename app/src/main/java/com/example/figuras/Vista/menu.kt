package com.example.figuras.Vista

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.figuras.R

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)


        val spinner: Spinner = findViewById<Spinner>(R.id.spnSelect)
        val btnIr = findViewById<Button>(R.id.btnIr)

        val opciones = arrayOf("Triangulo", "Rectangulo", "Circulo", "Cuadrado")
        val adaptador = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones)
        adaptador.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adaptador


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnIr.setOnClickListener {
            when (spinner.selectedItem.toString()) {
                "Triangulo" -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                "Rectangulo" -> {
                    val intent = Intent(this, rectanguloVista::class.java)
                    startActivity(intent)
                }
                "Circulo" -> {
                    val intent = Intent(this, CirculoVista::class.java)
                    startActivity(intent)
                }
                "Cuadrado" -> {
                    val intent = Intent(this, cuadradoVista::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}