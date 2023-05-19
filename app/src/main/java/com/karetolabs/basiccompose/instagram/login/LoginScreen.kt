package com.karetolabs.basiccompose.instagram.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(modifier = Modifier.align(Alignment.TopEnd))
        Body(modifier = Modifier.align(Alignment.Center))
        Footer(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

