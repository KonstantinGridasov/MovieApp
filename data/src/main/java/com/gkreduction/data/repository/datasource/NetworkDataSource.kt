package com.gkreduction.data.repository.datasource

import com.gkreduction.data.entity.CinemaResponse
import com.gkreduction.data.repository.CinemaNetworkApi
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val cinemaNetworkApi: CinemaNetworkApi) {

    fun fetchCinemaList(): Single<List<CinemaResponse>> {
        return cinemaNetworkApi.getCinemaList()
    }
}