package com.gkreduction.data.repository

import com.gkreduction.data.entity.CinemaResponse
import retrofit2.Response
import retrofit2.http.GET

interface CinemaNetworkApi {

    @GET("cinema/api")
    suspend fun getWeatherData(): Response<List<CinemaResponse>>

}
