package com.example.sesion2_06_a_contador_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sesion2_06_a_contador_base.ui.theme.Sesion2_06_A_Contador_BaseTheme
import com.example.sesion2_06_a_contador_base.viewmodels.ContadorViewModel
import com.example.sesion2_06_a_contador_base.views.ContadorView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sesion2_06_A_Contador_BaseTheme {
                ContadorView(ContadorViewModel())
            }
        }
    }
}

