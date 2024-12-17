package com.example.aplicacionretrofit.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.aplicacionretrofit.interfaz.RetrofitClient
import com.example.aplicacionretrofit.models.Heroe

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(navController: NavController) {
    val heroes = remember { mutableStateOf(listOf<Heroe>()) }

    LaunchedEffect(Unit) {
        heroes.value = RetrofitClient.apiService.getHeroes()
    }

    Box(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate("addHeroe") }) {
                    Icon(Icons.Default.Add, contentDescription = "Add Heroe")

                }
            }
        ) {
            Image(
                painter = rememberImagePainter("https://i.redd.it/wxm47kgjz5101.png"),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = 0.25f },
                contentScale = ContentScale.Crop
            )
            LazyColumn {
                items(heroes.value) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { navController.navigate("detail/${item.id}") },
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberImagePainter(item.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(MaterialTheme.shapes.medium)
                                    .background(MaterialTheme.colorScheme.surface),
                                contentScale = ContentScale.Fit
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp, end = 8.dp)
                            ) {
                                Text(
                                    text = item.name,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                                )
                                Text(
                                    text = item.powers,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}