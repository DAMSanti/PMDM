package com.example.corutinas.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeView() {
    // variable de estado para el contador
    var timerValue by remember { mutableStateOf(60) }
    // variable de estado para el color de fondo de la pantalla
    var backgroundColor by remember { mutableStateOf(Color.Blue) }
    // variable de estado del texto informativo sobre la descarga
    var downloadText by remember { mutableStateOf("Descarga no realizada") }
    // variable de estado del texto informativo sobre petición API
    var apiText by remember { mutableStateOf("sin consultar API") }
    // variable de estado para el scope de una corrutina
    val coroutineScope = rememberCoroutineScope()
    // variable de stado para almacenar el Job de una corrutina
    var timerJob by remember { mutableStateOf<Job?>(null) }

    Box(
        modifier = Modifier.fillMaxSize().background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botón Cambiar Color
            Button(onClick = {
                backgroundColor =
                    if (backgroundColor == Color.Blue) Color.Red else Color.Blue
            }) {
                Text("Cambiar Color")
            }
            // Botón DESCARGAR
            Button(onClick = {
                //el scope de la corrutina llama al constructor launch también se usa para otros casos async
                coroutineScope.launch {
                    // Cambiar el texto a "Descargando video"
                    downloadText = "Descargando video"
                    // Simular una espera de 10 segundos
                    delay(10000L)
                    // Cambiar el texto a "Finalizada la descarga"
                    downloadText = "Finalizada la descarga"
                }
            })
            {
                Text("DESCARGAR")
            }
            //Texto sobre estado de la descarga
            Text(text = downloadText)
            // Botón PETICIÓN API
            Button(onClick = {
                //el scope de la corrutina llama al constructor launch también se usa para otros casos async
                coroutineScope.launch {
                    // Cambiar el texto a "Descargando video"
                    apiText = "Iniciada la petición de la API"
                    // Simular una espera de 10 segundos
                    delay(10000L)
                    // Cambiar el texto a "Finalizada la descarga"
                    apiText = "Finalizada la peticion"
                } })
            {
                Text("PETICIÓN API")
            }
            // Texto relacionado con estado de la petición API
            Text(text = apiText)
            // Botón CONTADOR
            Button(onClick = {
                timerJob = coroutineScope.launch {
                    timerValue = 60 // Iniciar el temporizador desde 60
                    while (timerValue > 0) {
                        delay(1000L) // Esperar 1 segundo
                        timerValue-- // Decrementar en 1
                    }
                }
            }) {
                Text("CONTADOR")
            }
            Text(
                text = timerValue.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            // Botón DETENER
            Button(onClick = {
                // Cancelar la corrutina previa si existe
                timerJob?.cancel()
                timerJob = null
            })
            {
                Text("DETENER")
            }

        }
    }
}