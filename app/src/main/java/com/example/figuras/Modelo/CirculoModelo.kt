package com.example.ejercicio_figuras.Modelo

import com.example.ejercicio_figuras.Contrato.ContratoCirculo
import kotlin.math.PI
import kotlin.math.pow

class CirculoModelo: ContratoCirculo.Modelo {
    override fun Volumen(radio: Float): Float {
        return (PI*radio.pow(2)).toFloat()
    }

    override fun Circunferencia(radio: Float): Float {
        return (2*PI*radio).toFloat()
    }

    override fun valida(radio: Float): Boolean {
        return radio > 0

    }


}