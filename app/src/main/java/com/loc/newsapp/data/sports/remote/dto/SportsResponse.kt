package com.loc.newsapp.data.sports.remote.dto

import com.loc.newsapp.domain.model.sports.Sports


data class SportsResponse(
    val table: List<SportsDto>
)

data class SportsDto(
    val intRank: String?,
    val strTeam: String?,
    val strBadge: String?,
    val intPlayed: String?,
    val intWin: String?,
    val intPoints: String?
)

fun SportsDto.toStanding(): Sports {
    return Sports(
        rank = intRank ?: "",
        teamName = strTeam ?: "",
        badgeUrl = strBadge ?: "",
        played = intPlayed ?: "",
        wins = intWin ?: "",
        points = intPoints ?: ""
    )
}