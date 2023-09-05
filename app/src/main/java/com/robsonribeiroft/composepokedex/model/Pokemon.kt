package com.robsonribeiroft.composepokedex.model

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val picture: Int,
    val types: List<String>
)
