package com.robsonribeiroft.composepokedex.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.robsonribeiroft.composepokedex.R
import com.robsonribeiroft.composepokedex.model.Pokemon

class PokemonPreviewProvider: PreviewParameterProvider<Pokemon> {

    override val values: Sequence<Pokemon>
        get() = sequenceOf(
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
            )
        )
}