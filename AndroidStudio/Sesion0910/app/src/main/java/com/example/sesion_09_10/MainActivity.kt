package com.example.sesion_09_10

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion_09_10.ui.theme.Sesion0910Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sesion0910Theme {
                Content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content() {
    Column (modifier = Modifier.fillMaxSize()){
        ContenidoPrincipal(modifier = Modifier.weight(0.5f))
        AreaSeleccion(modifier = Modifier.weight(0.2f))
        AreaInformacion(modifier = Modifier.weight(0.2f))
        Footer(modifier = Modifier.weight(0.1f))
    }
}

@Composable
fun ContenidoPrincipal(modifier: Modifier) {
    Box (modifier = modifier
        .fillMaxWidth()
        .background(Color(0xFFFFEB3B))
        .padding(10.dp), contentAlignment = Alignment.Center){
        imagenPrincipal()
        BotonFlotante(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun imagenPrincipal() {
    Image(painter = painterResource(id = R.drawable.tormenta), contentDescription = "Imagen Principal", modifier = Modifier
        .fillMaxSize(0.9f)
        .clip(
            RoundedCornerShape(20.dp)
        ), contentScale = ContentScale.Crop)
}

@Composable
fun BotonFlotante(modifier: Modifier) {
    FloatingActionButton(
        onClick = {
        Log.d("PRUEBA", "Has pulsado me gusta")
    },
        modifier.padding(30.dp),
        containerColor= Color.White.copy(alpha = 0.4f),
        contentColor = Color.Red){
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Me gusta",
            //tint = Color.Red
        )
    }
}

@Composable
fun AreaSeleccion(modifier: Modifier) {
    val resImagenes = intArrayOf(R.drawable.strange, R.drawable.superman, R.drawable.manhatan, R.drawable.hulk, R.drawable.catwoman)
    val arrayContDesc = arrayOf("Dr. Strange", "Superman", "Dr. Manhatan", "Hulk", "Catwoman")
    Row (modifier = modifier
        .fillMaxWidth()
        .background(Color(0xAAFFEB3B))
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        for (i in 0 until resImagenes.size) {
            carruselImagenes(resImagenes[i], arrayContDesc[i])
        }
    }
}

@Composable
fun carruselImagenes(imagen : Int, contDesc : String) {
    Image(
        painter = painterResource(id = imagen),
        contentDescription = contDesc,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
    )
}


@Composable
fun AreaInformacion(modifier: Modifier) {
    Row (modifier = modifier
        .background(Color.Black)
        .padding(16.dp)
        .fillMaxWidth()
        .background(Color(0xFFFFF8A4)), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        InfoHeroe(modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun InfoHeroe(modifier : Modifier) {
    Image(painter = painterResource(id = R.drawable.hulk), contentDescription = "Hulk", modifier = modifier
        .padding(4.dp)
        .fillMaxHeight(), contentScale = ContentScale.FillHeight, alignment = Alignment.CenterStart)
    Column ( modifier.padding(4.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top){
        Text(text = "Hulk", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = "Enorme fuerza y vigor sobrehumanos, resistencia a las heridas; habilidad de saltar varios kilometros de un solo impulso", color = Color.Black, fontSize = 12.sp, fontStyle = FontStyle.Italic, lineHeight = 16.sp)
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Row (modifier = modifier
        .fillMaxWidth()
        .background(Color(0x11FFEB3B))
        .padding(10.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        Text(text = "Área 4", color = Color.Black)
    }
}