package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karetolabs.basiccompose.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Preview(showBackground = true)
@Composable
fun TestMyProgress() {
    MyProgress()
}

@Composable
fun MyProgressAdvance() {
    var showLoadingStatus by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        CircularProgressIndicator(progress = 0.6f, color = Color.Red, strokeWidth = 10.dp)
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { showLoadingStatus += 0.1f }) {
                Text(text = "aumentar")
            }
            Button(onClick = { showLoadingStatus -= 0.1f }) {
                Text(text = "reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoadingStatus by rememberSaveable { mutableStateOf(0f) }
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        if (showLoading) {
            CircularProgressIndicator(
                progress = showLoadingStatus,
                color = Color.Red,
                strokeWidth = 10.dp
            )
            CircularProgressIndicator(progress = 0.6f, color = Color.Red, strokeWidth = 10.dp)
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(color = Color.Red, backgroundColor = Color.Green)
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar Perfil")
        }

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { showLoadingStatus += 0.1f }) {
                Text(text = "aumentar")
            }
            Button(onClick = { showLoadingStatus -= 0.1f }) {
                Text(text = "reducir")
            }
        }
    }
}

