package com.example.ejercicio_figuras.Contrato

interface ContratoCirculo {
    interface Modelo {
        fun Volumen(radio: Float): Float
        fun Circunferencia(radio: Float): Float
        fun valida(radio: Float): Boolean
    }
    interface Vista {
        fun showVolumen(volumen: Float)
        fun showCircunferencia(circunferencia: Float)
        fun showError(msg: String)
    }
    interface Presentador {
        fun Volumen(radio: Float)
        fun Circunferencia(radio: Float)
    }


}