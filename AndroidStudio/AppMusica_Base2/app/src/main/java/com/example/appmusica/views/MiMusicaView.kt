package com.example.appmusica.views

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MiMusicaView() {

    Scaffold(
        topBar = { MiMusicaTopBar() },
        bottomBar = { MiMusicaBottomBar() },
        content = { HomeView()}
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
private fun MiMusicaBottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,

    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = null
                )
            },
            label = {
                Text("Artists")
            },
            selected = false,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            },
            label = {
                Text("Search")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
            },
            label = {
                Text("MyApp")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null
                )
            },
            label = {
                Text("Premium")
            },
            selected = false,
            onClick = {}
        )
    }
}
