package simulacro

import io.kotest.core.spec.style.DescribeSpec

class AdminiSpec:DescribeSpec({
    describe("TEST"){
        it("Test"){
            println(FechaAccion.obtenerFecha(8))
        }
    }
})