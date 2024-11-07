package com.example.ejercicio24_oct.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable("Detail/{id}/{user}", arguments = listOf(navArgument("id") { type = NavType.IntType },
            navArgument("user") { type = NavType.StringType })) {
            val num = it.arguments?.getInt("id")?:0
            val usuario = it.arguments?.getString("user")?:""
            DetailView(navController, num, usuario)
        }
    }
}