package com.example.ejercicio_figuras.Presentador

import com.example.ejercicio_figuras.Contrato.CuadradoContrato
import com.example.ejercicio_figuras.Modelo.ModeloCuadrado

class CuadradoPresentador(private val vista: CuadradoContrato.Vista) : CuadradoContrato.Presentador {

    private val modelo: CuadradoContrato.Modelo = ModeloCuadrado()
    override fun calcularArea(lado: Double) {
        if (modelo.verificarCuadrado(lado)) {
            val area = modelo.calcularArea(lado)
            vista.showArea(area)
        } else {
            vista.showError()
        }
    }

    override fun calcularPerimetro(lado: Double) {
        if (modelo.verificarCuadrado(lado)) {
            val perimetro = modelo.calcularPerimetro(lado)
            vista.showPerimetro(perimetro)
        } else {
            vista.showError()
        }

    }

}