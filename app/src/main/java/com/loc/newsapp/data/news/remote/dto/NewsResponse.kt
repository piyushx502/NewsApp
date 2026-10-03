package com.loc.newsapp.data.news.remote.dto

import com.loc.newsapp.domain.model.news.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)