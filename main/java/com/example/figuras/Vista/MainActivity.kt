package com.example.figuras.Vista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.ejercicio_figuras.Contrato.ContratoTriangulo

import com.example.ejercicio_figuras.Presentador.TrianguloPresenter
import com.example.figuras.R


class MainActivity : AppCompatActivity(), ContratoTriangulo.Vista{
   private lateinit var txtResultado: TextView
   private lateinit var presentador: ContratoTriangulo.Presentador

   fun setPresentador(presentador: ContratoTriangulo.Presentador) {
       this.presentador = presentador
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtl1: EditText =findViewById<EditText>(R.id.edtL1)
        val txtl2: EditText =findViewById<EditText>(R.id.edtL2)
        val txtl3: EditText =findViewById<EditText>(R.id.edtL3)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)
        val btnTipo: Button =findViewById<Button>(R.id.btnTipo)
        txtResultado = findViewById(R.id.txvRes)
        //definimos el presentardor
        presentador= TrianguloPresenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.perimetro(l1,l2,l3)
        }
        //listener del boton para definir el tipo de triangulo
        btnTipo.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.tipo(l1,l2,l3)
        }
        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.area(l1,l2,l3)
        }
    }

    override fun showArea(area: Float) {
        txtResultado.text="El area es: $area"
    }

    override fun showPerimetro(perimetro: Float) {
        txtResultado.text="El perimetro es: $perimetro"
    }

    override fun showTipo(tipo: String) {
        txtResultado.text="El tipo es: $tipo"
    }

    override fun showError(msg: String) {
        txtResultado.text=msg

    }


}