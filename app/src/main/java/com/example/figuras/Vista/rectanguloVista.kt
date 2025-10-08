package com.example.figuras.Vista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio_figuras.Contrato.Rectangulo_contract

import com.example.ejercicio_figuras.Presentador.cls_Rectangulo_presenter
import com.example.figuras.R


class rectanguloVista : AppCompatActivity(), Rectangulo_contract.rectangulo_vista{
   private lateinit var txtResultado: TextView
   private lateinit var presentador: Rectangulo_contract.rectangulo_Presenter

   fun setPresentador(presentador: Rectangulo_contract.rectangulo_Presenter) {
       this.presentador = presentador
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo)
        val txtl1: EditText =findViewById<EditText>(R.id.edtL1)
        val txtl2: EditText =findViewById<EditText>(R.id.edtL2)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)
        val btnRegresar: Button =findViewById<Button>(R.id.btnRegresar)
        txtResultado = findViewById(R.id.txvRes)
        //definimos el presentardor
        presentador= cls_Rectangulo_presenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnRegresar.setOnClickListener{
            finish()
        }
        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toDouble()
            val l2=txtl2.text.toString().toDouble()
            presentador.calcularPerimetro(l1,l2)

        }
        //listener del boton para definir el tipo de triangulo


        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toDouble()
            val l2=txtl2.text.toString().toDouble()
            presentador.calcularArea(l1,l2)
        }
    }

    override fun showArea(area: Double) {
        txtResultado.text="El area es: $area"
    }

    override fun showPerimetro(perimetro: Double) {
        txtResultado.text="El perimetro es: $perimetro"

    }


}