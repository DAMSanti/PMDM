package com.example.testbotones

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testbotones.ui.theme.TestBotonesTheme
import androidx.compose.material3.IconButtonDefaults

class MainActivity : ComponentActivity() {
    private var n: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestBotonesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp, bottom = 40.dp),
                    color = Color.LightGray,
                    border = BorderStroke(5.dp, Color.White),
                ) {
                    Content()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Content() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotonNormal(onClick = { onClick() })
            Spacer(modifier = Modifier.height(35.dp))
            BotonElevated(onClick = { onClick() })
            Spacer(modifier = Modifier.height(35.dp))
            BotonBorde(onClick = { onClick() })
            Spacer(modifier = Modifier.height(35.dp))
            BotonIcono(onClick = { onClick() })
            Spacer(modifier = Modifier.height(35.dp))
        }
    }

    @Composable
    fun BotonNormal(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp, start = 50.dp, end = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = "Click me",
                fontSize = 30.sp
            )
        }
    }

    @Composable
    fun BotonElevated(onClick: () -> Unit) {
        ElevatedButton(
            onClick = onClick,
            contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp, start = 50.dp, end = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = CutCornerShape(16.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 5.dp
            ),
        ) {
            Text(
                text = "Click me",
                fontSize = 30.sp
            )
        }
    }

    @Composable
    fun BotonBorde(onClick: () -> Unit) {
        OutlinedButton(
            onClick = onClick,
            contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp, start = 50.dp, end = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(4.dp, Color.Black),
            shape = MaterialTheme.shapes.extraLarge,
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 5.dp
            ),
        ) {
            Text(
                text = "Click me",
                fontSize = 30.sp
            )
        }
    }

    @Composable
    fun BotonIcono(onClick: () -> Unit) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color.Red
            )
        ) {
            Row {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Click me",
                    fontSize = 30.sp,
                )
            }
        }
    }

    fun onClick() {
        n++
        Log.d("MainActivity", "Bienvenido a Android! $n")
    }
}

