package com.example.aplicacionretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.example.aplicacionretrofit.controller.AppNavigation
import com.example.aplicacionretrofit.ui.theme.AplicacionRetrofitTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionRetrofitTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = rememberImagePainter("https://i.redd.it/wxm47kgjz5101.png"),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().graphicsLayer { alpha = 0.25f },
                        contentScale = ContentScale.Crop
                    )
                    AppNavigation()
                }
            }
        }
    }
}

