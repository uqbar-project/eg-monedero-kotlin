package ar.edu.unsam.algo2.vehiculos

import java.math.BigDecimal

class BusinessException(msg: String) : RuntimeException(msg)

class Monedero(var monto: BigDecimal = BigDecimal(100)) {

    fun poner(cuanto: BigDecimal) {
        this.validarMonto(cuanto)
        this.sumarMonto(cuanto)
    }

    fun sacar(cuanto: BigDecimal) {
        this.validarMonto(cuanto)
        if (monto < cuanto) {
            throw BusinessException("No puede sacar más de $ $monto $")
        }
        this.sumarMonto(cuanto.negate())
    }

    fun sumarMonto(valor: BigDecimal) {
        monto = monto.add(valor)
    }

    fun validarMonto(cuanto: BigDecimal) {
        if (cuanto.toDouble() <= 0) {
            throw BusinessException("$cuanto: el monto a ingresar debe ser un valor positivo")
        }
    }

    override fun toString() = "Monedero ($ $monto)"
}