package simulacro

import java.time.LocalDate
import kotlin.properties.Delegates

abstract class Tarea {
    var cumplida = false
    lateinit var banda: Banda
    open var mes by Delegates.notNull<Int>()
    fun dueDate() = LocalDate.now()

    abstract fun execute()
}

class RecolectarDinero(override var mes: Int, var comerciante: Comerciante) : Tarea() {
    override fun execute(){
        banda.saldo += (comerciante.ventasObtenidas * 0.1).toInt()
    }
}

class AbrirDeposito(override var mes: Int,var comerciante: ComercianteConDeposito): Tarea() {
    override fun execute() {
        banda.saldo -= (comerciante.metrosCuadradosDeposito*100)
    }
}

class PrestarDinero(override var mes: Int, var montoAPrestar: Int): Tarea(){
    override fun execute() {
        banda.saldo -= montoAPrestar
    }
}

class CobrarCuota(override var mes: Int): Tarea() {

}

