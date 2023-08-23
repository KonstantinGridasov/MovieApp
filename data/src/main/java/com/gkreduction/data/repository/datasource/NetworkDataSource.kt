package com.gkreduction.data.repository.datasource

import com.gkreduction.data.entity.CinemaResponse
import com.gkreduction.data.repository.CinemaNetworkApi
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val cinemaNetworkApi: CinemaNetworkApi) {

    suspend fun fetchCinemaList(): Response<List<CinemaResponse>> {
        return cinemaNetworkApi.getWeatherData()
    }
}