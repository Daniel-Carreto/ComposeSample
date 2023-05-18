package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TestMyTextComponent() {
    MyTextComponent()
}

@Composable
fun MyTextComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Green)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraLight)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        )))
        //Lo mismo pero sin style con un textdecoration directo en el Text
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        ))
        Text(text = "Esto es un ejemplo", fontSize = 35.sp)
    }
}
