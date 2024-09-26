package prueba

fun main() {
    var persona = Persona(1, "Santi", 38, "M", "Español", true)
    var deportista = Deportista(2, "Santi", 38, "M", "Español", true, "Formula 1", true)

    println(persona.getPersona())

    println(deportista.getDeportista())

    deportista.setNombre("Santi F1")
}