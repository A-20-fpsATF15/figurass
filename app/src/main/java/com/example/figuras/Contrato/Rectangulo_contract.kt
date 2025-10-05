package com.example.ejercicio_figuras.Contrato 

interface Rectangulo_contract{
    interface rectangulo_Model{
        fun calcularArea(base: Double, altura: Double): Double
        fun calcularPerimetro(base: Double, altura: Double): Double
        fun verificarRectangulo(base: Double, altura: Double): Boolean

    }
    interface rectangulo_Presenter {
        fun calcularArea(base: Double, altura: Double)
        fun calcularPerimetro(base: Double, altura: Double)
        fun verificarRectangulo(base: Double, altura: Double)

    }
    interface rectangulo_vista{
        fun showArea(area: Double)
        fun showPerimetro(perimetro: Double)
        fun showError()
        fun showRectanguloValido( esRectangulo: Boolean)
    }
}