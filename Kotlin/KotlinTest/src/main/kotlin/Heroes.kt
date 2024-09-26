package prueba

class Heroes (var id: Int = 0,
              var nombre: String = "",
              var poder: String = "",
              var company: String = "",
              var origin: String = "",
              var isHeroe: Boolean = true) {

    fun getHeroe(): String {
        val header = String.format("%-10s %-15s %-30s %-10s %-15s %-10s", "ID", "Nombre", "Poder", "Company", "Origin", "isHeroe")
        val row ="-".repeat(header.length)
        val datos = String.format("%-10d %-15s %-30s %-10s %-15s %-10s", id, nombre, if (poder.length > 30) poder.substring(0, 27) + "..." else poder , company, origin, if (isHeroe==true) "Heroe" else "Villano")
        return header + "\n" + row + "\n" + datos + "\n" + row
    }

    fun addPoderes(poderes: String) {
        this.poder += ", $poderes"
    }

    fun cambiaHeroe() {
        this.isHeroe = !this.isHeroe
    }
}