package com.example.ejercicio_figuras.Presentador

import com.example.ejercicio_figuras.Contrato.ContratoTriangulo
import com.example.ejercicio_figuras.Modelo.TrianguloModelo

class TrianguloPresenter(private val vista: ContratoTriangulo.Vista): ContratoTriangulo.Presentador {
    private val modelo : ContratoTriangulo.Modelo = TrianguloModelo()

    override fun area(l1: Float, l2: Float, l3: Float) {
        if(modelo.valida(l1,l2,l3)==true){
            val a= modelo.area(l1,l2,l3)
            vista.showArea(a)
        }else{
            vista.showError("Datos incorrectos")
        }
    }

    override fun perimetro(l1: Float, l2: Float, l3: Float) {
        if(modelo.valida(l1,l2,l3)){
            val p=modelo.perimetro(l1,l2,l3)
            vista.showPerimetro(p)
        }else{
            vista.showError("Datos incorrectos")
        }
    }

    override fun tipo(l1: Float, l2: Float, l3: Float) {
        if(modelo.valida(l1,l2,l3)){
            val t=modelo.tipo(l1,l2,l3)
            vista.showTipo(t)
        }else{
            vista.showError("Datos incorrectos")
        }
    }
}