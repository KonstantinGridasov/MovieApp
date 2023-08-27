package com.gkreduction.data.repository.datasource

import com.gkreduction.data.entity.MovieResponse
import com.gkreduction.data.repository.MovieNetworkApi
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val movieNetworkApi: MovieNetworkApi) {

    suspend fun fetchCinemaList(): List<MovieResponse> {
        return movieNetworkApi.getMovies()
    }
}