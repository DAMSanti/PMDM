package prueba

class HeroeEncapsulado (private var id: Int = 0,
                        private var nombre: String = "",
                        private var poder: String = "",
                        private var company: String = "",
                        private var origin: String = "",
                        private var isHeroe: Boolean = true) {

    fun getHeroe(): String {
        val header = String.format("%-10s %-15s %-30s %-10s %-15s %-10s", "ID", "Nombre", "Poder", "Company", "Origin", "isHeroe")
        val row ="-".repeat(header.length)
        val datos = String.format("%-10d %-15s %-30s %-10s %-15s %-10s", id, nombre, if (poder.length > 30) poder.substring(0, 27) + "..." else poder , company, origin, if (isHeroe==true) "Heroe" else "Villano")
        return header + "\n" + row + "\n" + datos + "\n" + row
    }

    fun getHeroeId(): Int {
        return id
    }

    fun getHeroeName(): String {
        return nombre
    }

    fun getHeroePoder(): String {
        return poder
    }

    fun getHeroeCompany(): String {
        return company
    }

    fun getHeroeOrigin(): String {
        return origin
    }

    fun getHeroeIsHeroe(): Boolean {
        return isHeroe
    }

    fun setHeroeName(nombre: String) {
        this.nombre = nombre
    }

    fun setHeroePoder(poder: String) {
        this.poder = poder
    }

    fun setHeroeCompany(company: String) {
        this.company = company
    }

    fun setHeroeOrigin(origin: String) {
        this.origin = origin
    }

    fun setHeroeIsHeroe(isHeroe: Boolean) {
        this.isHeroe = isHeroe
    }

    fun setHeroeId(id: Int) {
        this.id = id
    }
}