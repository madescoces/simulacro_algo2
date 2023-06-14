package simulacro

import java.time.LocalDate

const val DIA_TAREA_TIPICO = 5
class FechaAccion {
    companion object{
        fun obtenerFecha(mes:Int): LocalDate {
            return LocalDate.of(LocalDate.now().year, mes, DIA_TAREA_TIPICO)
        }
    }
}
