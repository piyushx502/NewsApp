package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    val news =newsUseCases.getNews(
        sources = listOf("bbc-news", "abc-news", "al-jazeera-english", "cnn",
            "the-new-york-times", "the-wall-street-journal", "the-washington-post",
            "bloomberg", "business-insider", "cbs-news", "entertainment-weekly",
            "espn", "fox-news", "nbc-news", "reuters", "techcrunch",
            "the-verge", "time", "wired", "usa-today")
    ).cachedIn(viewModelScope)

}