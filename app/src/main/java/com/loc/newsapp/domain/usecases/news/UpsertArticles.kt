package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.model.news.Article
import com.loc.newsapp.domain.repository.NewsRepository

class UpsertArticles(
    private val newsRepository: NewsRepository) {
    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article)
    }

}