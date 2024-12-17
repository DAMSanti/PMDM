package com.example.sesion3_02_base.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun HomeView() {
    // Estados para los TextFields
    var url by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val context = LocalContext.current

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre componentes
        ) {
            // TextField para la URL
            TextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("Introduce la URL") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER WEB
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://campus.educantabria.es"))
                    context.startActivity(intent)},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER WEB")
            }

            // TextField para la latitud
            TextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Introduce la Latitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para la longitud
            TextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Introduce la Longitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER MAP
            Button(
                onClick = { /* Lógica para ver el mapa */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER MAP")
            }

            // TextField para el mensaje
            TextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Escribe un mensaje") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para el número de teléfono
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Escribe un número de teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón ENVIAR A
            Button(
                onClick = { /* Lógica para enviar el mensaje */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENVIAR A")
            }

            // Botón COMPARTIR
            Button(
                onClick = { /* Lógica para compartir */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("COMPARTIR")
            }
        }
    }
}
