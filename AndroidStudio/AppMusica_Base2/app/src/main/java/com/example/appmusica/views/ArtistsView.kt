package com.example.appmusica.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArtistsView(){
    Box(modifier = Modifier.fillMaxSize().padding(8.dp).background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center){
        Text(modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            text="Artists",
            fontSize =30.sp,
            color = MaterialTheme.colorScheme.primary)
    }
}