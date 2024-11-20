package com.example.appmusica.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.appmusica.R
import com.example.appmusica.model.AudioMusical
import com.example.appmusica.model.Reflexion
import java.time.LocalDate

fun getReflexionDelDia(): Reflexion? {
    val reflexiones = Reflexion.Companion.reflexiones;
    val today = LocalDate.now()
    return reflexiones.find { it.fecha == today }
}

fun getAudioMasReciente(): AudioMusical? {
    return AudioMusical.audiosMusicales.maxByOrNull { it.fecha }
}

@Composable
fun AudioMasReciente() {
    val audioMasReciente = getAudioMasReciente()
    if (audioMasReciente != null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Audio más reciente",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                GlideImage(
                    model = audioMasReciente.imagenUrl,
                    contentDescription = "Imagen del audio más reciente",
                    modifier = Modifier.fillMaxSize(),++-
                    
                    contentScale = ContentScale.Crop,
                    requestBuilder = {
                        it.placeholder(R.drawable.judeline_brujeria)
                            .error(R.drawable.la_la_love_you_nos_volveremos_a_ver)
                    }
                )




               /* Image(
                    painter = painterResource(id = audioMasReciente.imagen),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )*/
                IconButton(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Text(
                    text = audioMasReciente.titulo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(Color.Yellow.copy(alpha = 0.7f))
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview
@Composable
fun ContentHomeView() {
    val reflexionDelDia = getReflexionDelDia()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Frase del día", style = MaterialTheme.typography.headlineMedium)
        if (reflexionDelDia != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = reflexionDelDia.frase,
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = reflexionDelDia.autor,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        } else {
            Text(text = "No hay reflexión para el día de hoy.")
        }
        AudioMasReciente()
    }
}