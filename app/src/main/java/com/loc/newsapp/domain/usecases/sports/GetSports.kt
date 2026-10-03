package com.loc.newsapp.domain.usecases.sports

import com.loc.newsapp.domain.model.sports.Sports
import javax.inject.Inject

class GetSports @Inject constructor(
    private val sportsRepository: SportsRepository
) {
    suspend operator fun invoke(): List<Sports> {
        return sportsRepository.getLaLigaStandings()
    }
}