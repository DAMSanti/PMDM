package com.example.ejercicio24_oct.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.ContentView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ejercicio24_oct.components.ActionButton
import com.example.ejercicio24_oct.components.MainButton
import com.example.ejercicio24_oct.components.SpaceV
import com.example.ejercicio24_oct.components.TitleBar
import com.example.ejercicio24_oct.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeView(navController: NavController) {
    Scaffold (topBar = {
            CenterAlignedTopAppBar(title = { TitleBar(texto = "TOP BAR")},
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary))
       },
            floatingActionButton = {
            ActionButton()
       })
    {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    var n = 123
    var u = "Usuario"
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleView(name = "Home View")
        SpaceV(20.dp)
        MainButton(name = "To Detail",
            onClick = {navController.navigate("Detail/${n}/${u}")})
    }
}
