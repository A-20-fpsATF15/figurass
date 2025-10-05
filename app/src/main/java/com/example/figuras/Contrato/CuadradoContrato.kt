package com.example.ejercicio_figuras.Contrato

interface CuadradoContrato {
    interface Modelo {
        fun calcularArea(lado: Double): Double
        fun calcularPerimetro(lado: Double): Double
        fun verificarCuadrado(lado: Double): Boolean
    }
    interface Vista {
        fun showArea(area: Double)
        fun showPerimetro(perimetro: Double)
        fun showError()
    }
    interface Presentador {
        fun calcularArea(lado: Double)
        fun calcularPerimetro(lado: Double)
    }

}