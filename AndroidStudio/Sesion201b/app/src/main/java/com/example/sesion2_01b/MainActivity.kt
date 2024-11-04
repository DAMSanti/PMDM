package com.example.sesion2_01b

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion2_01b.ui.theme.Sesion201bTheme

class MainActivity : ComponentActivity() {
    val listaImagenes = listOf(R.drawable.foto01, R.drawable.foto02, R.drawable.foto03,
        R.drawable.foto04, R.drawable.foto05, R.drawable.foto06, R.drawable.foto07,
        R.drawable.foto08, R.drawable.foto09, R.drawable.foto10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion201bTheme (darkTheme = true) {
                var foto by remember { mutableStateOf(R.drawable.foto01) }
                Column (modifier = Modifier.fillMaxSize()){
                    introImagen(foto, Modifier.weight(0.25f))
                    //stories({ nuevaFoto -> foto = nuevaFoto }, Modifier.weight(0.2f))
                    CajaFoto(foto,
                        Modifier
                            .fillMaxSize()
                            .weight(0.75f))
                }
            }
        }
    }

    @Composable
    fun BotonConImagen(imageResId: Int, onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .size(100.dp) // Tamaño del botón redondo
                .clip(CircleShape) // Botón redondo
                .background(Color.LightGray)
                .clickable { onClick() } // Acción al hacer clic
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Ajustar la imagen dentro del botón
            )
        }
    }

    @Composable
    fun stories(onFotoClick: (Int) -> Unit, modifier: Modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {
            items(listaImagenes) { imageResId ->
                BotonConImagen(imageResId = imageResId, onClick = { onFotoClick(imageResId) })
            }
        }
    }

    @Composable
    fun CajaFoto(foto: Int, modifier: Modifier) {
        Box(
            modifier = modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = foto), contentDescription = "Foto", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Fit)
        }
    }

    @Composable
    fun introImagen(foto: Int, modifier: Modifier) {
        var fotografia = foto;
        var picture by remember { mutableStateOf("0")}
        Column (modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text ="Selecciona una foto", fontSize = 14.sp, color = Color.Blue, modifier = Modifier.padding(8.dp))
            TextField(value = picture, onValueChange = {picture = it}, label = { Text("Nº de Fotografía") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            Button(modifier = Modifier.padding(4.dp), onClick = { fotografia = picture.toInt() } ) {
                Text("Aceptar", fontSize = 20.sp)
            }
        }
    }
}
