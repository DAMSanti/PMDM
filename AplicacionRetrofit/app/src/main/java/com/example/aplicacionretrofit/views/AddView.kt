package com.example.aplicacionretrofit.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacionretrofit.interfaz.RetrofitClient
import com.example.aplicacionretrofit.models.Heroe
import kotlinx.coroutines.launch
import retrofit2.HttpException

@Composable
fun AddView(navController: NavController) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var powers by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = powers,
                    onValueChange = { powers = it },
                    label = { Text("Powers") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = imageUrl,
                    onValueChange = { imageUrl = it },
                    label = { Text("Image URL") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    coroutineScope.launch {
                        try {
                            val newItem = Heroe(id = HeroeIdManager.getNextId(context), name = name, powers = powers, imageUrl = imageUrl)
                            RetrofitClient.apiService.addHeroe(newItem)
                            navController.popBackStack()
                        } catch (e: HttpException) {
                            if (e.code() == 500) {
                                errorMessage = "Server error. Please try again later."
                            } else {
                                errorMessage = "An unexpected error occurred."
                            }
                        } catch (e: Exception) {
                            errorMessage = "An unexpected error occurred."
                        }
                    }
                }) {
                    Text("Add Heroe")
                }
                errorMessage?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = it, color = androidx.compose.ui.graphics.Color.Red)
                }
            }
        }
    }
}