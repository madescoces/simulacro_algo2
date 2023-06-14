package simulacro

abstract class Persona {
    abstract var banda: Banda
    abstract fun condicionAceptarTarea(tarea: Tarea): Boolean
}

class AltoPerfil(override var banda:Banda): Persona() {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Culposo(override var banda:Banda): Persona() {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Alternante(override var banda:Banda): Persona() {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Cabulero(override var banda:Banda): Persona() {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Combinada(override var banda:Banda): Persona() {
    override fun condicionAceptarTarea(tarea: Tarea) = true
}

class Comerciante(var ventasObtenidas: Int)

class ComercianteConDeposito(var metrosCuadradosDeposito: Int)



