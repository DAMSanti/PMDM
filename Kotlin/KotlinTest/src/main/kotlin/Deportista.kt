package prueba

class Deportista(id:Int, nombre:String, edad:Int, sexo:String, nacionalidad:String, isVivo:Boolean,
                 private var deporte: String,
                 private var esProfesional:Boolean):Persona(id, nombre, edad, sexo, nacionalidad, isVivo) {

    fun getDeportista(): String {
        val header = String.format("%-10s %-15s %-10s %-10s %-15s %-10s %-15s %-10s", "ID", "Nombre", "Edad", "Sexo", "Nacionalidad", "isVivo", "Deporte", "Profesional")
        val row ="-".repeat(header.length)
        val datos = String.format("%-10d %-15s %-10d %-10s %-15s %-10s %-15s %-10s", id, nombre, edad, sexo, nacionalidad, if (isVivo==true) "Vivo" else "Fallecido", deporte, if (esProfesional==true) "Profesional" else "Aficionado")
        return header + "\n" + row + "\n" + datos + "\n" + row
    }

    fun getDeporte(): String {
        return deporte
    }

    fun isProfesional(): Boolean {
        return esProfesional
    }

    fun setDeporte(deporte: String) {
        this.deporte = deporte
    }

    fun setEsProfesional(esProfesional: Boolean) {
        this.esProfesional = esProfesional
    }
}
