package com.example.ejercicio_figuras.Modelo

import com.example.ejercicio_figuras.Contrato.CuadradoContrato
import kotlin.math.pow

class ModeloCuadrado: CuadradoContrato.Modelo {
    override fun calcularArea(lado: Double): Double {
        return  lado.pow(2)
    }

    fun recursividad(lado: Double, con: Int): Double {

        if (con <= 0) {
            return 0.0
        } else {
            return lado + recursividad(lado, con - 1)
        }
    }


    override fun calcularPerimetro(lado: Double): Double {
        return recursividad(lado, 4)
    }

    override fun verificarCuadrado(lado: Double): Boolean {
            return lado > 0
    }
}