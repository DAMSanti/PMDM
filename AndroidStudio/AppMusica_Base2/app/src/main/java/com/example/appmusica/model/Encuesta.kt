package com.example.appmusica.model

sealed class Encuesta (val pregunta:String, val respuestas:List<String>)
{
    object EncuestaHoy:Encuesta(
        "¿cual es el módulo que menos te gusta?",
        listOf("AD","DI","PSP","PMDM")
    )
    object EncuestaAyer:Encuesta(
       "¿que gardo de satisfacción tienes con el profe de PMDM?",
       listOf("Totalmente satisfecho","Bastante satisfecho",
            "Poco satisfecho","Nada satisfecho")
    )
}
