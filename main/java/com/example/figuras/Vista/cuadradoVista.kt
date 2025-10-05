package com.example.figuras.Vista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio_figuras.Contrato.CuadradoContrato
import com.example.ejercicio_figuras.Presentador.CuadradoPresentador

import com.example.figuras.R


class cuadradoVista : AppCompatActivity(), CuadradoContrato.Vista{
   private lateinit var txtResultado: TextView
   private lateinit var presentador: CuadradoContrato.Presentador

   fun setPresentador(presentador: CuadradoContrato.Presentador) {
       this.presentador = presentador
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtl1: EditText =findViewById<EditText>(R.id.edtL1)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)
        txtResultado = findViewById(R.id.txvRes)
        //definimos el presentardor
        presentador= CuadradoPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPerimetro.setOnClickListener{
            val l1= txtl1.text.toString().toDouble()
            presentador.calcularPerimetro(l1)

        }
        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1= txtl1.text.toString().toDouble()
            presentador.calcularArea(l1)
        }
    }

    override fun showArea(area: Double) {
        txtResultado.text="El area es: $area"
    }

    override fun showPerimetro(perimetro: Double) {
        txtResultado.text="El perimetro es: $perimetro"
    }

    override fun showError() {
        txtResultado.text="Error"

    }


}