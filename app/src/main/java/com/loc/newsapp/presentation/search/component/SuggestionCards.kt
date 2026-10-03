package com.loc.newsapp.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding1


@Composable
fun SuggestionCards(
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit = {}
) {
    val categories = listOf("Sports", "Technology", "Business", "Health", "Entertainment")

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MediumPadding1)
        ) {
            SearchCard(
                category = categories[0],
                modifier = Modifier.weight(1f),
                onClick = { onCategorySelected(categories[0]) })
            SearchCard(
                category = categories[1],
                modifier = Modifier.weight(1f),
                onClick = { onCategorySelected(categories[1]) })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MediumPadding1)
        ) {
            SearchCard(
                category = categories[2],
                modifier = Modifier.weight(1f),
                onClick = { onCategorySelected(categories[2]) })
            SearchCard(
                category = categories[3],
                modifier = Modifier.weight(1f),
                onClick = { onCategorySelected(categories[3]) })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SearchCard(
                category = categories[4],
                onClick = { onCategorySelected(categories[4]) })
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}