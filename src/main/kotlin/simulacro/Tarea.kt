package simulacro

import java.time.LocalDate
import kotlin.properties.Delegates

abstract class Tarea(open val mes:Int) {
    var cumplida = false
    lateinit var administrador: Administrador
    lateinit var banda: Banda
    fun dueDate() = LocalDate.now()

    fun execute(admin: Administrador){
        administrador = admin
        doExecute()
    }

    fun isBandaInitialized(): Boolean {
        return ::banda.isInitialized
    }

    abstract fun doExecute()
}

class COLLECTMONEY(mes: Int, var comerciante: Comerciante) : Tarea(mes) {
    override fun doExecute(){
        banda.saldo += (comerciante.ventasObtenidas * 0.1).toInt()
    }
}

class OPENDEPOSIT(mes: Int,var comerciante: ComercianteConDeposito): Tarea(mes) {
    override fun doExecute() {
        banda.saldo -= (comerciante.metrosCuadradosDeposito*100)
    }
}

class LENDMONEY(mes: Int, var montoAPrestar: Int): Tarea(mes){
    var cuotas = 4

    override fun doExecute() {
        banda.saldo -= montoAPrestar
        repeat(cuotas){ administrador.crearTarea(COLLECTFEE(mes, (montoAPrestar*2)/cuotas)) }
    }
}

class COLLECTFEE(mes: Int, val monto: Int): Tarea(mes) {
    override fun doExecute() {
        banda.saldo += monto
    }
}

