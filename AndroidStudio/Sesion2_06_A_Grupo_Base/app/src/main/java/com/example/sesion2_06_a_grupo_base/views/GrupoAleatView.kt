package com.example.sesion2_06_a_grupo_base.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.sesion2_06_a_grupo_base.viewModel.GrupoAleatViewModel

@Composable
fun GrupoAleatView(viewModel: GrupoAleatViewModel) {
    //val grupoAleatNumbers= listOf(3,4,8,13)
    val grupos:List<Int> by viewModel.grupo.observeAsState(initial=listOf(0,0,0,0))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (grupos.isEmpty()) {
            Text(text = "Grupo", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        } else {
            GrupoAleatNumbers(numbers = grupos)
        }
        Button(onClick = { viewModel.generarGrupo() }) {
            Text(text = "Generar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun GrupoAleatNumbers(numbers: List<Int>) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        items(numbers) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape)
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}

