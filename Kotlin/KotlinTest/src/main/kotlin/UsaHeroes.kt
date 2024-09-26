package prueba

fun main() {
    var heroe: Heroes = Heroes(1, "Superman", "Volar", "DC", "Krypton", true)
    heroe.addPoderes("Super Fuerza")
    heroe.cambiaHeroe()
    println(heroe.getHeroe())
    heroe.addPoderes("Visión de Rayos X")
    heroe.cambiaHeroe()
    println(heroe.getHeroe())


}