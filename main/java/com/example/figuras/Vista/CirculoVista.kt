package com.example.figuras.Vista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio_figuras.Contrato.ContratoCirculo
import com.example.ejercicio_figuras.Presentador.CirculoPresenter

import com.example.figuras.R


class CirculoVista : AppCompatActivity(), ContratoCirculo.Vista{
   private lateinit var txtResultado: TextView
   private lateinit var presentador: ContratoCirculo.Presentador

   fun setPresentador(presentador: ContratoCirculo.Presentador) {
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
        presentador= CirculoPresenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            presentador.Volumen(l1)

        }
        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()

            presentador.Circunferencia(l1)
        }
    }

    override fun showVolumen(volumen: Float) {
        txtResultado.text="El volumen es: $volumen"
    }

    override fun showCircunferencia(circunferencia: Float) {
        txtResultado.text="La circunferencia es: $circunferencia"

    }

    override fun showError(msg: String) {
        txtResultado.text=msg

    }


}