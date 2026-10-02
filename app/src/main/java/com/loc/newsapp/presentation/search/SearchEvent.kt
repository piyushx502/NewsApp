package com.loc.newsapp.presentation.search

import androidx.room.Query

 sealed class SearchEvent {

    data class  UpdateSearchQuery(val searcQuery: String): SearchEvent()

    object SearchNews : SearchEvent()
}