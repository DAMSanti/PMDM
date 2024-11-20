package com.example.appmusica.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmusica.R
import com.example.appmusica.components.BottomNavigationButton

@Composable
fun MiMusicaView() {
    Scaffold(
        topBar = { MiMusicaTopBar() },
        bottomBar = { MiMusicaBottomBar() },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                ContentHomeView()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMiMusicaView() {
    MiMusicaView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiMusicaTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Mi Musica",
                style = MaterialTheme.typography.headlineLarge
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

@Composable
fun MiMusicaBottomBar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Asegura que la fila ocupe todo el ancho
            ) {
                BottomNavigationButton(
                    icon = Icons.Filled.Home,
                    text = "Home",
                    onClick = { /* Acción para Home */ },
                    modifier = Modifier.weight(1f) // Distribuye el ancho equitativamente
                )
                BottomNavigationButton(
                    icon = ImageVector.vectorResource(R.drawable.singer),
                    text = "Artists",
                    onClick = { /* Acción para Artists */ },
                    modifier = Modifier.weight(1f)
                )
                BottomNavigationButton(
                    icon = Icons.Filled.Search,
                    text = "Search",
                    onClick = { /* Acción para Search */ },
                    modifier = Modifier.weight(1f)
                )
                BottomNavigationButton(
                    icon = Icons.Filled.Person,
                    text = "MyApp",
                    onClick = { /* Acción para MyApp */ },
                    modifier = Modifier.weight(1f)
                )
                BottomNavigationButton(
                    icon = painterResource(id = R.drawable.premium3),
                    text = "Premium",
                    onClick = { /* Acción para Premium */ },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    )
}
