package com.loc.newsapp.presentation.sports


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.model.sports.Sports
import com.loc.newsapp.domain.usecases.sports.GetSports
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val getSports: GetSports
) : ViewModel() {

    private val _sports = mutableStateOf<List<Sports>>(emptyList())
    val sports: State<List<Sports>> = _sports

    init {
        getLaLigaData()
    }

    private fun getLaLigaData() {
        viewModelScope.launch {
            _sports.value = getSports()
        }
    }
}