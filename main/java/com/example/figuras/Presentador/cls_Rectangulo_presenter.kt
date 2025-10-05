package com.example.ejercicio_figuras.Presentador

import com.example.ejercicio_figuras.Contrato.Rectangulo_contract
import com.example.ejercicio_figuras.Modelo.cls_Rectangulo_Model

class cls_Rectangulo_presenter(private val vista: Rectangulo_contract.rectangulo_vista,) : Rectangulo_contract.rectangulo_Presenter
{
    private val modelo: Rectangulo_contract.rectangulo_Model = cls_Rectangulo_Model()

    override fun calcularArea(base: Double, altura: Double) {
      if(modelo.verificarRectangulo(base, altura)){
            val area = modelo.calcularArea(base, altura)
            vista.showArea(area)
      }
    }

    override fun calcularPerimetro(base: Double, altura: Double) {
        if(modelo.verificarRectangulo(base, altura)){
            val perimetro = modelo.calcularPerimetro(base, altura)
            vista.showPerimetro(perimetro)
        }

    }


}