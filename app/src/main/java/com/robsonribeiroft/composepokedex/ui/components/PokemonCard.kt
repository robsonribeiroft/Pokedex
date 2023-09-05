package com.robsonribeiroft.composepokedex.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.robsonribeiroft.composepokedex.model.Pokemon
import com.robsonribeiroft.composepokedex.ui.preview.PokemonPreviewProvider
import com.robsonribeiroft.composepokedex.ui.theme.TypeBug
import com.robsonribeiroft.composepokedex.ui.theme.TypeDark
import com.robsonribeiroft.composepokedex.ui.theme.TypeDragon
import com.robsonribeiroft.composepokedex.ui.theme.TypeElectric
import com.robsonribeiroft.composepokedex.ui.theme.TypeFairy
import com.robsonribeiroft.composepokedex.ui.theme.TypeFighting
import com.robsonribeiroft.composepokedex.ui.theme.TypeFire
import com.robsonribeiroft.composepokedex.ui.theme.TypeFlying
import com.robsonribeiroft.composepokedex.ui.theme.TypeGhost
import com.robsonribeiroft.composepokedex.ui.theme.TypeGrass
import com.robsonribeiroft.composepokedex.ui.theme.TypeGround
import com.robsonribeiroft.composepokedex.ui.theme.TypeIce
import com.robsonribeiroft.composepokedex.ui.theme.TypeNormal
import com.robsonribeiroft.composepokedex.ui.theme.TypePoison
import com.robsonribeiroft.composepokedex.ui.theme.TypePsychic
import com.robsonribeiroft.composepokedex.ui.theme.TypeRock
import com.robsonribeiroft.composepokedex.ui.theme.TypeSteel
import com.robsonribeiroft.composepokedex.ui.theme.TypeWater

@Preview(showBackground = true)
@Composable
fun PokemonCard(
    @PreviewParameter(PokemonPreviewProvider::class) pokemon: Pokemon
) {
    Card(
        modifier = Modifier.shadow(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(pokemon.getColorByPrimaryType()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(0.dp, 0.dp, Int.MAX_VALUE.dp, Int.MAX_VALUE.dp))
                    .background(Color.White)
            ) {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center)
                        .padding(4.dp)
                        .heightIn(max = 40.dp),
                    painter = painterResource(pokemon.picture), contentDescription = pokemon.name
                )
            }
            Text(
                modifier = Modifier.padding(top = 4.dp),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraLight,
                text = pokemon.id.formatPokemonId()
            )
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = pokemon.name,
                fontWeight = FontWeight.Medium
            )
            TypeInfo(type = pokemon.primaryType())
            Spacer(modifier = Modifier.size(4.dp))
            TypeInfo(type = pokemon.secondaryType())
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
private fun TypeInfo(type: String?) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(if (!type.isNullOrEmpty()) 1f else 0f)
            .padding(horizontal = 8.dp)
            .border(
                BorderStroke(1.dp, Color.White.copy(0.2f)),
                MaterialTheme.shapes.extraSmall
            )
            .padding(vertical = 2.dp, horizontal = 8.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Light,
        text = type ?: "type not found",
    )
}

private fun Pokemon.getColorByPrimaryType(): Color {
    return when(primaryType().lowercase()) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> TypeNormal
    }
}

private fun Pokemon.primaryType(): String = types.first()

private fun Pokemon.secondaryType(): String? {
    return try {
        types[1]
    } catch (e: IndexOutOfBoundsException) {
        null
    }
}

fun Int.formatPokemonId(): String {
    return String.format("#%03d", this)
}