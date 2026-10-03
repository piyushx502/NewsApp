package com.loc.newsapp.data.sports.remote.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {
    @GET("api/v1/json/3/lookuptable.php")
    suspend fun getLaLigaStandings(
        @Query("l") leagueId: String = "4335",
        @Query("s") season: String = "2024-2025"
    ): SportsResponse
}