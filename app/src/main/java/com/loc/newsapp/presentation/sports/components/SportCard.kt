package com.loc.newsapp.presentation.sports.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.sports.Sports

@Composable
fun SportCard(sport: Sports, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.input_background)),
        border = BorderStroke(1.dp, colorResource(id = R.color.placeholder)),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "#${sport.rank}",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_title)
            )
            Spacer(modifier = Modifier.width(16.dp))

            AsyncImage(
                model = sport.badgeUrl,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = sport.teamName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.text_title)
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${sport.points} pts",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.text_title)
                )
                Text(
                    text = "${sport.played} Played",
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}