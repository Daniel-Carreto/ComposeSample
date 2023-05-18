package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Preview(showBackground = true)
@Composable
fun TestTextFieldComponent() {
    MyTextFieldComponent()
}

@Composable
fun MyTextFieldOutlined() {
    var myText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains("a")) {
                        it.replace("a", "")

                    } else {
                        it
                    }
            },
            label = {
                Text(text = "Introduce tu nombre")
            },
            modifier = Modifier.padding(24.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyTextFieldComponent() {
    var myText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = myText, onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")

                } else {
                    it
                }
        }, label = {
            Text(text = "Introduce tu nombre")
        })
    }
}