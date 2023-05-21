package com.karetolabs.basiccompose.catalogo

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karetolabs.basiccompose.R
import com.karetolabs.basiccompose.catalogo.model.Superhero
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Ale", "Dany", "Kevin")
    LazyColumn {
        item {
            Text(text = "Primer Item")
        }
        items(7) {
            Text(text = "Primer Item $it")
        }
        items(myList) {
            Text(text = "Hola Soy $it.")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeors()) { superhero ->
            ItemHero(superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroControlView() {
    val context = LocalContext.current
    val recyclerView = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = recyclerView,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeors()) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf {
                recyclerView.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        recyclerView.animateScrollToItem(0)
                    }
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un botón")
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<Superhero>> = getSuperHeors().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { (publisher, mySuperhero) ->
            stickyHeader {
                Text(
                    text = publisher,
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            items(mySuperhero) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}


@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Superhero avatar",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperHeors(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
        Superhero("Spiderman", "Peter Parker", "DC", R.drawable.ic_avatar),
    )
}
