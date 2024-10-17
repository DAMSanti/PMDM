package com.example.actividad10_10

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad10_10.ui.theme.Actividad1010Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        enableEdgeToEdge()
        setContent {
            Actividad1010Theme {
                Contenido()
            }
        }
    }

    @Preview
    @Composable
    fun Contenido() {
        var color by remember { mutableStateOf(Color.Transparent) }
        Column (modifier = Modifier.fillMaxSize()){
            Saludo(modifier = Modifier.weight(0.2f))
            Botones(modifier = Modifier.weight(0.10f), onColorChange = { color = it })
            Caja(modifier = Modifier.weight(0.4f), color = color)
        }
    }

    @Composable
    fun Caja(modifier: Modifier, color: Color) {
        Box(
            modifier = modifier.padding(8.dp)
                .fillMaxWidth()
                .background(color),
            contentAlignment = Alignment.Center
        ) {

        }
    }

    @Composable
    fun Saludo(modifier : Modifier) {
        var nombre by remember { mutableStateOf("")}
        var apellidos by remember { mutableStateOf("")}
        var mensaje by remember { mutableStateOf("") }
        Column(modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            TextField( value=nombre,onValueChange ={nombre=it} ,
                label={Text("Nombre")},
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                modifier = Modifier.fillMaxWidth())
            OutlinedTextField( value=apellidos,onValueChange ={apellidos=it} ,
                label={Text("Apellidos")},
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                modifier = Modifier.fillMaxWidth())
            botonAceptar("Aceptar", onClick={ mensaje = "Hola $nombre $apellidos"})
            textoMensaje(mensaje)
           }

    }

    @Composable
    fun Botones(modifier : Modifier, onColorChange: (Color) -> Unit) : Color {
        var color by remember { mutableStateOf(Color.Transparent)}
        Column(modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {
            botonAceptar("Rojo", onClick = { onColorChange(Color.Red) })
            botonAceptar("Verde", onClick = { onColorChange(Color.Green) })
            botonAceptar("Azul", onClick = { onColorChange(Color.Blue) })
        }
        return color
    }

    @Composable
    private fun textoMensaje(mensaje: String) {
        Text(text = mensaje, fontSize =  20.sp, fontWeight = FontWeight.Bold, color = Color.Blue, modifier = Modifier.fillMaxWidth())
    }

    @Composable
    fun botonAceptar(texto : String, onClick : ()->Unit){
        Button(onClick = onClick) {
            Text(texto, fontSize = 20.sp)
        }
    }

}
