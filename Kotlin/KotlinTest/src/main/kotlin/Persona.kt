package prueba

open class Persona (protected var id: Int = 0,
                    protected var nombre: String = "no name",
                    protected var edad: Int = 0,
                    protected var sexo: String = "ND",
                    protected var nacionalidad: String = "ND",
                    protected var isVivo: Boolean = true) {

    fun getPersona(): String {
        val header = String.format("%-10s %-15s %-10s %-10s %-15s %-10s", "ID", "Nombre", "Edad", "Sexo", "Nacionalidad", "isVivo")
        val row ="-".repeat(header.length)
        val datos = String.format("%-10d %-15s %-10d %-10s %-15s %-10s", id, nombre, edad, sexo, nacionalidad, if (isVivo==true) "Vivo" else "Fallecido")
        return header + "\n" + row + "\n" + datos + "\n" + row
    }

    fun cambiaVivo() {
        this.isVivo = !this.isVivo
    }

    internal fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    internal fun setEdad(edad: Int) {
        this.edad = edad
    }
}