package com.loc.newsapp.domain.usecases.sports

import com.loc.newsapp.domain.model.sports.Sports
interface SportsRepository {
    suspend fun getLaLigaStandings(): List<Sports>
}