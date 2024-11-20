package com.example.appmusica.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.appmusica.R
import com.example.appmusica.data.audiosMusicales
import com.example.appmusica.data.audiosMusicalesExt
import com.example.appmusica.data.reflexiones
import com.example.appmusica.model.Encuesta
import com.example.appmusica.model.Reflexion
import java.time.LocalDate

@Composable
fun HomeView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        FraseDelDiaSection()

        Spacer(modifier = Modifier.height(24.dp))

        AudioMasRecienteSection()

        Spacer(modifier = Modifier.height(24.dp))

        EncuestaSection()
    }
}


@Composable
fun FraseDelDiaSection(){
    val reflexion= reflexionDelDia()
    Text(
        text = "Frase del día",
        style = MaterialTheme.typography.headlineMedium.copy(fontSize = 32.sp),
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(8.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start

        ) {
            Text(
                text = "\"${reflexion.frase}\"",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    fontSize = 20.sp
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "- ${reflexion.autor}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun AudioMasRecienteSection() {
    val audioMasReciente = audiosMusicalesExt.maxBy { it.fecha }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Audio más reciente",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            // Imagen de fondo del audio más reciente
            GlideImage(
                model = audioMasReciente.urlImagen,
                contentDescription = "Imagen del audio más reciente",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                // agregado de placeholder de carga y de error (opcional)
                loading = placeholder(R.drawable.loading),
                failure = placeholder(R.drawable.error)
            )

            // Texto de título y artista con fondo amarillo semitransparente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow.copy(alpha = 0.7f))
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            ) {
                Text(
                    text = "${audioMasReciente.titulo} - ${audioMasReciente.artist}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Botón de Play centrado sobre la imagen
            IconButton(
                onClick = { /* Acción de reproducción del audio */ },
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(50.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )

            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

fun reflexionDelDia(): Reflexion {
    val fechaActual = LocalDate.now()
    return reflexiones.find { it.fecha == fechaActual } ?: Reflexion(
        frase = "HOY NO HAY FRASES",
        autor = "",
        fecha = fechaActual
    )
}

@Composable
fun EncuestaSection() {
    val context = LocalContext.current // Contexto para mostrar los Toast
    var respuestaSeleccionada by remember { mutableStateOf<String?>(Encuesta.EncuestaHoy.respuestas.first()) } // Estado para la respuesta seleccionada
    var encuestaActivada by remember { mutableStateOf<Boolean>(true)}
    if(encuestaActivada) {
        Column(
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Text(text = Encuesta.EncuestaHoy.pregunta, fontSize = 20.sp)
            // Lista de RadioButtons
            Encuesta.EncuestaHoy.respuestas.forEach { respuesta ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = respuesta == respuestaSeleccionada,
                            onClick = {
                                respuestaSeleccionada = respuesta
                                val pos = Encuesta.EncuestaHoy.respuestas.indexOf(respuesta)
                                Toast
                                    .makeText(
                                        context,
                                        "Seleccionaste: $respuesta en posicion $pos",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        )
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = respuesta == respuestaSeleccionada,
                        onClick = {
                            respuestaSeleccionada = respuesta
                            Toast.makeText(
                                context,
                                "Has pulsado justo en el RadioButton de la respuesta $respuesta",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = respuesta)
                }
            }

            // Botón Enviar
            Button(
                enabled = encuestaActivada,
                onClick = {
                    if (respuestaSeleccionada != null) {
                        val pos = Encuesta.EncuestaHoy.respuestas.indexOf(respuestaSeleccionada)
                        Toast.makeText(
                            context,
                            "Enviaste: $respuestaSeleccionada de numero $pos",
                            Toast.LENGTH_SHORT
                        ).show()
                        encuestaActivada = false
                    } else {
                        Toast.makeText(
                            context,
                            "Selecciona una respuesta antes de enviar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {
                Text(text = "Enviar")
            }
        }
    }
    else{
        Text(text = "          ")
    }
}