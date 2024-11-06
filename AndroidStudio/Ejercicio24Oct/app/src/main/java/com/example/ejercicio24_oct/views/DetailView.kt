package com.example.ejercicio24_oct.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ejercicio24_oct.components.ActionButton
import com.example.ejercicio24_oct.components.MainButton
import com.example.ejercicio24_oct.components.MainIconButton
import com.example.ejercicio24_oct.components.SpaceV
import com.example.ejercicio24_oct.components.TitleBar
import com.example.ejercicio24_oct.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun DetailView(navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { TitleBar(texto = "TOP BAR DETAIL") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentDetailView(navController)
    }
}

@Composable
fun ContentDetailView(navController: NavController) {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TitleView(name = "Detail View")
        SpaceV(20.dp)
        //MainButton(name = "Return Home") {
        //    navController.popBackStack()
        //}
    }
}

