package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karetolabs.basiccompose.ui.theme.BasicComposeTheme

@Preview(showBackground = true)
@Composable
fun TestMyBox() {
    BasicComposeTheme {
        MyBox()
    }
}


@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ) //Permite hacer un scroll,
        , contentAlignment = Alignment.BottomCenter
        ){
            Text(text = "Esto es un texto")
        }
    }
}