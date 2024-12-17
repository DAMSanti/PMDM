package com.example.aplicacionretrofit.controller

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionretrofit.views.AddView
import com.example.aplicacionretrofit.views.DetailView
import com.example.aplicacionretrofit.views.MainView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainView(navController) }
        composable("detail/{itemId}") { backStackEntry ->
            DetailView(backStackEntry.arguments?.getString("itemId") ?: "")
        }
        composable("addHeroe") { AddView(navController) }
    }
}