package com.example.ejercicio24_oct.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun TitleView(name: String) {
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun SpaceV() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun SpaceV(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}

@Composable
fun MainButton(name: String, onClick:() -> Unit) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.onPrimary, containerColor = MaterialTheme.colorScheme.primary)) {
        Text(text = name)
    }
}