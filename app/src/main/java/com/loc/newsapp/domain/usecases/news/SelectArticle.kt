package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.model.news.Article
import com.loc.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article?{
       return newsRepository.selectArticle(url)
    }
}