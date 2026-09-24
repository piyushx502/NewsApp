package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description : String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Lost in thought, found in the moment.",
        description = "The moon forgot its way home, so it followed the sound of rain.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lost in thought, found in the moment.",
        description = "The moon forgot its way home, so it followed the sound of rain.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lost in thought, found in the moment.",
        description = "The moon forgot its way home, so it followed the sound of rain.",
        image = R.drawable.onboarding3
    )
)