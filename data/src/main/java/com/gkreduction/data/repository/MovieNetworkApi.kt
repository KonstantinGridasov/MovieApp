package com.gkreduction.data.repository

import com.gkreduction.data.FIELD_COUNTRY_LIST
import com.gkreduction.data.entity.MovieResponse
import retrofit2.http.GET

interface MovieNetworkApi {

    @GET(FIELD_COUNTRY_LIST)
    suspend fun getMovies(): List<MovieResponse>

}
