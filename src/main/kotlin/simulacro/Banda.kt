package simulacro
abstract class Banda {
    open lateinit var Vito: Administrador
    var saldo = 0
    val miembros = mutableSetOf<MiembroBanda>()
    val tareasAsignadas = mutableSetOf<Tarea>()

    fun addPersona(miembro: MiembroBanda){
        miembros.add(miembro)
    }

    fun removePersona(miembro:MiembroBanda){
        miembros.remove(miembro)
    }

    fun asignarTarea(tarea: Tarea){
        if (!tarea.isBandaInitialized() && condicionAceptarTarea(tarea)){
            tareasAsignadas.add(tarea)
            tarea.banda = this
        }
    }

    fun lider() = miembros.first()
    fun enBancarrota() = saldo <= 0

    fun cobrar(monto: Int){ saldo += monto}
    fun gastar(monto: Int){ Vito.saldo -= monto}

    abstract fun condicionAceptarTarea(tarea: Tarea): Boolean
    abstract fun realizarTarea(tarea:Tarea)
}

class Forajida(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) = miembros.any{ it.condicionAceptarTarea(tarea) }
    override fun realizarTarea(tarea:Tarea) {

    }
}

class Sorora(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) = miembros.all{ it.condicionAceptarTarea(tarea) }
    override fun realizarTarea(tarea:Tarea) {

    }
}

class Tipica(override var Vito: Administrador) : Banda() {
    override fun condicionAceptarTarea(tarea: Tarea) = lider().condicionAceptarTarea(tarea)
    override fun realizarTarea(tarea:Tarea) {

    }
}


