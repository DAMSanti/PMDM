package com.example.descuentosapp.views


import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.TwoCards



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    val context= LocalContext.current

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var showDialog by remember { mutableStateOf(false) }

        TwoCards(
            title1 = "Total",
            number1=precioDescuento,
            title2 = "Descuento",
            number2=totalDescuento
        )

        MainTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = { descuento = it }, label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            if (precio.isNotEmpty() && descuento.isNotEmpty()) {
                val precioDouble = precio.toDoubleOrNull()
                val descuentoDouble = descuento.toDoubleOrNull()
                if (precioDouble != null && descuentoDouble != null) {
                    totalDescuento = calcularDescuento(precioDouble, descuentoDouble)
                    precioDescuento = calcularPrecio(precioDouble, descuentoDouble)
                } else {
                    Toast.makeText(context, "Los valores deben ser numéricos", Toast.LENGTH_SHORT).show()
                }
            } else {
                //Toast.makeText(context, "Los datos están incompletos", Toast.LENGTH_SHORT).show()
                showDialog = true
            }
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            totalDescuento = 0.0
            precioDescuento = 0.0
            Toast.makeText(context, "Has pulsado limpiar", Toast.LENGTH_SHORT).show()
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { },
                confirmButton = {
                    MainButton(text = "Aceptar") {
                        showDialog = false
                    }
                },
                title = { Text(text = "Alerta") },
                text = { Text(text = "Debes escribir el precio y el descuento") }
            )
        }
    }
}

fun calcularPrecio(precio:Double, descuento:Double): Double{
    val res = precio - calcularDescuento(precio, descuento )
    return kotlin.math.round(res * 100) /100.0
}

fun calcularDescuento(precio:Double, descuento:Double): Double {
    val res = precio / 100 * descuento
    return kotlin.math.round(res * 100) /100.0
}


