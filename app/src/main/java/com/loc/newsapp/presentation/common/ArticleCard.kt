package com.loc.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.news.Article
import com.loc.newsapp.domain.model.news.Source
import com.loc.newsapp.presentation.onboarding.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.onboarding.Dimens.SmallIconSize
import com.loc.newsapp.ui.theme.NewsAppTheme


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    article: Article
) {
    val context = LocalContext.current

    Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.input_background)),
        border = BorderStroke(1.dp, colorResource(id = R.color.placeholder)),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .clip(MaterialTheme.shapes.medium)
                .border(width = 1.dp,
                    color = colorResource(id = R.color.body),
                    shape = MaterialTheme.shapes.medium)
                .padding(8.dp)
                .clickable {
                    onClick()

                }
        ) {
            AsyncImage(
                modifier = Modifier.size(ArticleCardSize)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context)
                    .data(article.urlToImage)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.padding(horizontal = ExtraSmallPadding)
                    .height(ArticleCardSize)
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.text_title
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(verticalAlignment =  Alignment.CenterVertically) {
                    Text(
                        text = article.source.name,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(
                            id = R.color.body
                        )
                    )
                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = null,
                        modifier = Modifier.size(SmallIconSize),
                        tint = colorResource(id = R.color.body)
                    )
                    Text(
                        text = article.publishedAt,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(
                            id = R.color.body
                        )
                    )
                }
            }

        }

    }


}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview(){
    NewsAppTheme {
        ArticleCard(
            onClick  = {},
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her traint broke down. Her phone died.And then she met her save in a ",
                url = "",
                urlToImage = ""
            ))
    }
}