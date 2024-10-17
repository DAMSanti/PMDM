package com.example.sesion16_10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion16_10.ui.theme.Sesion1610Theme
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.Dp

class MainActivity : ComponentActivity() {
    val nombresDeSuperheroes = listOf(
        "Spider-Man", "Iron Man", "Captain America", "Thor", "Hulk",
        "Black Widow", "Doctor Strange", "Scarlet Witch", "Black Panther", "Ant-Man",
        "Captain Marvel", "Hawkeye", "Vision", "War Machine", "Falcon",
        "Winter Soldier", "Star-Lord", "Gamora", "Rocket Raccoon", "Groot",
        "Drax", "Mantis", "Nebula", "Wasp", "Shang-Chi",
        "Deadpool", "Wonder Woman", "Superman", "Batman", "Aquaman"
    )

    @Composable
    fun TextSuperheroe(nombre: String) {
        Text(
            text = nombre,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF8899FF),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion1610Theme {
                listaColumnaDos()
            }
        }
    }

    @Composable
    fun listaColumnaDos() {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            item { Titulo() }
            items(nombresDeSuperheroes){
                name->  filaSuperHeroe(name = name)
            }
        }
    }

    @Composable
    fun filaSuperHeroe(name : String) {
        val context = LocalContext.current
        var isChecked by remember { mutableStateOf(false) }

        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(color = Color ( 0xFF8899FF),
                    shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ){
            Text(
                text = name,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.weight(1f)
                    .padding(16.dp)
            )
            Checkbox(checked = isChecked, onCheckedChange = { checked -> isChecked = checked
                val message = if (checked) {
                    "$name activado"
                } else {
                    "$name desactivado"
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            })
        }
    }

    @Composable
    private
    fun EspacioVertical(dp: Dp) {
        Spacer(modifier = Modifier.height(dp))
    }

    @Composable
    fun Titulo() {
        Text(
            text = "Lista de Superheroes",
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .padding(top = 50.dp, bottom = 20.dp)
                .fillMaxWidth(),
            textAlign = Center
        )
    }


    @Composable
    fun listaColumna() {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Titulo()
            for (nombre in nombresDeSuperheroes) {
                TextSuperheroe(nombre)
                EspacioVertical(8.dp)
            }
        }
    }



}

