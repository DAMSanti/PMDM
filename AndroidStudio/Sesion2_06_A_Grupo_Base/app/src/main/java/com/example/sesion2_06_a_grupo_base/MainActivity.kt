package com.example.sesion2_06_a_grupo_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sesion2_06_a_grupo_base.ui.theme.Sesion2_06_A_Grupo_BaseTheme
import com.example.sesion2_06_a_grupo_base.viewModel.GrupoAleatViewModel
import com.example.sesion2_06_a_grupo_base.views.GrupoAleatView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sesion2_06_A_Grupo_BaseTheme {
                GrupoAleatView(GrupoAleatViewModel())
            }
        }
    }
}

