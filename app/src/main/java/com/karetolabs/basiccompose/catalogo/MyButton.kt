package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TestMyButton() {
    MyButton()
}

@Composable
fun MyButton() {
    var enabled by remember { mutableStateOf(true) }
    var myText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                enabled = !enabled
                println("Es un ejemplo")
            },
            border = BorderStroke(5.dp, Color.Green),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
            ),
            enabled = enabled,

            ) {
            Text(text = "Hola")
        }
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedButton(
            onClick = {
                enabled = !enabled
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
            ),
        ) {
            Text(text = "Hola!")
        }
        Spacer(modifier = Modifier.size(10.dp))
        TextButton( //Sin borde
            onClick = {
                enabled = !enabled
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta, contentColor = Color.Blue
            ),
        ) {
            Text(text = "Hola!")
        }
    }
}
