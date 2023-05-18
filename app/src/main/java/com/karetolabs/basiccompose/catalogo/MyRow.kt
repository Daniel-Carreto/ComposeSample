package com.karetolabs.basiccompose.catalogo


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TestMyRow(){
    MyRow()
}

@Composable
fun MyRow(){
    Row(modifier = Modifier
        .fillMaxSize()
        .horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp).background(Color.Cyan))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp).background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp).background(Color.Blue))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp).background(Color.DarkGray))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp).background(Color.Cyan))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp).background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp).background(Color.Blue))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp).background(Color.DarkGray))
        Text(text = "Ejemplo 4", modifier = Modifier.width(100.dp).background(Color.DarkGray))

        //Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan).weight(1f))
        //Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Red).weight(1f))
        //Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Blue).weight(1f))
        //Text(text = "Ejemplo 4", modifier = Modifier.background(Color.DarkGray).weight(1f))
    }
}
