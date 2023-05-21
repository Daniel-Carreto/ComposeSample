package com.karetolabs.basiccompose.catalogo

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(getSuperHeors()) { superhero ->
            ItemHero(superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
