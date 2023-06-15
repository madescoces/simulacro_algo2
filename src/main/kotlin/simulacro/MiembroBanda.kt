package simulacro

abstract class MiembroBanda(val banda:Banda) {
    abstract fun condicionAceptarTarea(tarea: Tarea): Boolean
}

class MiembroAltoPerfil(banda:Banda): MiembroBanda(banda) {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class MiembroCulposo(banda:Banda): MiembroBanda(banda) {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class MiembroAlternante(banda:Banda): MiembroBanda(banda) {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class MiembroCabulero(banda:Banda): MiembroBanda(banda) {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class MiembroCombinado(banda:Banda): MiembroBanda(banda) {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Comerciante(var ventasObtenidas: Int)

class ComercianteConDeposito(var metrosCuadradosDeposito: Int)



