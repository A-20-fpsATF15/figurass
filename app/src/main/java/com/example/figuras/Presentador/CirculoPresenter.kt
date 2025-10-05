package com.example.ejercicio_figuras.Presentador

import com.example.ejercicio_figuras.Contrato.ContratoCirculo
import com.example.ejercicio_figuras.Modelo.CirculoModelo

class CirculoPresenter(private val vista: ContratoCirculo.Vista): ContratoCirculo.Presentador {

    private val modelo: ContratoCirculo.Modelo = CirculoModelo()

    override fun Volumen(radio: Float) {
        if (modelo.valida(radio)) {
            val v = modelo.Volumen(radio)
            vista.showVolumen(v)
        } else {
            vista.showError("Datos incorrectos")
        }

    }


    override fun Circunferencia(radio: Float) {
        if (modelo.valida(radio)) {
            val c = modelo.Circunferencia(radio)
            vista.showCircunferencia(c)
        } else {
            vista.showError("Datos incorrectos")
        }
    }
}