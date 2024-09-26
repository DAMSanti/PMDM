package prueba

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    HolaMundo("Santi", "rojo")
    HolaArcoiris("Santi")
}

fun HolaMundo (Nombre: String, color: String) {
    val colorCode = detectaColor(color)
    println("${colorCode}Hola, $Nombre!\u001B[0m")
}

fun HolaArcoiris(Nombre: String) {
    val texto = "Hola, $Nombre"
    for (i in texto.indices) {
        val colorCode = detectaColorNum(((i % 6) + 1).toString())
        print("${colorCode}${texto[i]}\u001B[0m")
    }
}

fun detectaColor(color: String):String {
    val colorCode = when (color.toLowerCase()) {
        "rojo" -> "\u001B[31m"
        "verde" -> "\u001B[32m"
        "amarillo" -> "\u001B[33m"
        "azul" -> "\u001B[34m"
        "morado" -> "\u001B[35m"
        "cian" -> "\u001B[36m"
        else -> "\u001B[0m" // Reset color
    }
    return colorCode;
}

fun detectaColorNum(color: String):String {
    val colorCode = when (color.toLowerCase()) {
        "1" -> "\u001B[31m"
        "2" -> "\u001B[32m"
        "3" -> "\u001B[33m"
        "4" -> "\u001B[34m"
        "5" -> "\u001B[35m"
        "6" -> "\u001B[36m"
        else -> "\u001B[0m" // Reset color
    }
    return colorCode;
}

