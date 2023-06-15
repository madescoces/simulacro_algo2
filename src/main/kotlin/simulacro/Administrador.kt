package simulacro

class Administrador {
    var saldo = 0

    val tareas = mutableListOf<Tarea>()
    val bandas = mutableListOf<Banda>()

    fun reclutar(banda: Banda){
        bandas.add(banda)
    }

    fun crearTarea(tarea: Tarea){
        tareas.add(tarea)
    }

    fun asignarTareas(){
        tareas.forEach{ tarea -> bandas.forEach{ banda -> banda.asignarTarea(tarea) }}
    }

    fun ejecutarTareas(){
        tareas.forEach{ tarea -> tarea.execute(this) }
    }

}

