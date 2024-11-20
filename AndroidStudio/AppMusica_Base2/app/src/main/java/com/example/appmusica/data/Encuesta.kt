package com.example.appmusica.data

sealed class Encuesta (pregunta:String, respuestas:List<String>)
{
    object encuestaHoy:Encuesta(
        "¿cual es el módulo que menos te gusta?",
        listOf("AD","DI","PSP","PMDM")
    )
    object encuestaAyer:Encuesta(
        "¿que gardo de satisfacción tienes con el profe de PMDM?",
        listOf("Totalmente satisfecho","Bastante satisfecho",
            "Poco satisfecho","Nada satisfecho")
    )
}
