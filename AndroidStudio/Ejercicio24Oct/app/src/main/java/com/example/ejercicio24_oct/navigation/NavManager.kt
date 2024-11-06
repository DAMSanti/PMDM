package com.example.ejercicio24_oct.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio24_oct.views.DetailView
import com.example.ejercicio24_oct.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Detail") {
            DetailView(navController)
        }
    }
}