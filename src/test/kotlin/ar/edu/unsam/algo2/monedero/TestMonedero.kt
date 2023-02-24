package ar.edu.unsam.algo2.monedero

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class TestMonedero : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Dado un monedero") {
        val monedero = Monedero(BigDecimal(100))

        it("al poner plata sube el monedero") {
            monedero.poner(BigDecimal(25))
            monedero.monto.shouldBe(BigDecimal(125))
        }

        it("no se puede poner un monto negativo") {
            shouldThrow<BusinessException> { monedero.poner(BigDecimal(-1)) }
        }

        it("no se puede poner cero pesos") {
            shouldThrow<BusinessException> { monedero.poner(BigDecimal(0)) }
        }

        it("al sacar plata sube el monedero") {
            monedero.sacar(BigDecimal(100))
            monedero.monto.shouldBe(BigDecimal(0))
        }

        it("no se puede sacar un monto negativo") {
            shouldThrow<BusinessException> { monedero.sacar(BigDecimal(-1)) }
        }

        it("no se puede sacar cero pesos") {
            shouldThrow<BusinessException> { monedero.sacar(BigDecimal(0)) }
        }

        it("no se puede sacar más plata de la que hay") {
            shouldThrow<BusinessException> { monedero.sacar(BigDecimal(101)) }
        }

        it("muestra el saldo en la representación del string") {
            monedero.toString().shouldBe("Monedero ($ 100)")
        }
    }

})