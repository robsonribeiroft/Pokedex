package com.robsonribeiroft.composepokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robsonribeiroft.composepokedex.R
import com.robsonribeiroft.composepokedex.model.Pokemon

@Preview
@Composable
fun PokemonGridList(
    pokemons: List<Pokemon> = MOCK_POKEMON_LIST
) {
    val maxLineSpan = 2

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Adaptive(64.dp), content = {
            (items(
                count = pokemons.size,
                span = { GridItemSpan(maxLineSpan) }
            ) { index ->
                PokemonCard(pokemon = pokemons[index])
            })
        }
    )
}

val MOCK_POKEMON_LIST = listOf(
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        types = listOf("normal", "flying"),
        picture = R.drawable.pidgeot,
        description = "Bird Pokemon"
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        types = listOf("water"),
        picture = R.drawable.blastoise,
        description = "Shellfish Pokemon"
    ),
)