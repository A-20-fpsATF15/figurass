package com.example.ejercicio_figuras.Modelo

import com.example.ejercicio_figuras.Contrato.Rectangulo_contract

class cls_Rectangulo_Model: Rectangulo_contract.rectangulo_Model {
    override fun calcularArea(base: Double, altura: Double): Double {
        val area = base * altura
        return area
    }

    override fun calcularPerimetro(base: Double, altura: Double): Double {
        val perimetro = 2 * (base + altura)
        return perimetro
    }

    override fun verificarRectangulo(base: Double, altura: Double): Boolean {
        return base > 0 && altura > 0
    }




}