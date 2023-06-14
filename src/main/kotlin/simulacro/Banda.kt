package simulacro
abstract class Banda {
    open lateinit var Vito: Administrador
    var saldo = 0
    val integrantes = mutableSetOf<Persona>()
    lateinit var tareaAsignada: Tarea

    fun addPersona(persona: Persona){
        integrantes.add(persona)
    }
    fun removePersona(persona:Persona){
        integrantes.remove(persona)
    }
    fun asignarTarea(tarea: Tarea){
        condicionAceptarTarea(tarea)
        tareaAsignada = tarea
    }
    fun lider() = integrantes.first()
    fun enBancarrota() = saldo <= 0

    fun cobrar(monto: Int){ saldo += monto}
    fun gastar(monto: Int){ Vito.saldo -= monto}

    //VALIDACIONES//
    open fun condicionAceptarTarea(tarea: Tarea){
        if (enBancarrota()) throw BusinessException("No tenemos un mango")
    }
}
class Forajida(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) {
        super.condicionAceptarTarea(tarea)
        integrantes.any{ it.condicionAceptarTarea(tarea) }
    }
}
class Sorora(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) {
        super.condicionAceptarTarea(tarea)
        integrantes.all{ it.condicionAceptarTarea(tarea) }
    }
}
class Tipica(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) {
        super.condicionAceptarTarea(tarea)
        lider().condicionAceptarTarea(tarea)
    }
}


