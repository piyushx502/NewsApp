package com.loc.newsapp.data.sports.repository

import com.loc.newsapp.data.sports.remote.dto.SportsApi
import com.loc.newsapp.data.sports.remote.dto.toStanding
import com.loc.newsapp.domain.model.sports.Sports
import com.loc.newsapp.domain.usecases.sports.SportsRepository
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val sportsApi: SportsApi
) : SportsRepository {

    override suspend fun getLaLigaStandings(): List<Sports> {
        return try {
            val response = sportsApi.getLaLigaStandings()
            response.table.map { it.toStanding() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}