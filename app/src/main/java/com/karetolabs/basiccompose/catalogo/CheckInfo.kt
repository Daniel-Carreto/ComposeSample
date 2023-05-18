package com.karetolabs.basiccompose.catalogo

data class CheckInfo(
    val title: String,
    val selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
