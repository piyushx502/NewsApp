package com.loc.newsapp.presentation.bookmark

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel(){

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }
    private fun getArticles(){
        newsUseCases.selectArticles().onEach {
        _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)
    }
}