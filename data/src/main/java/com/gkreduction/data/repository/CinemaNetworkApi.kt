package com.gkreduction.data.repository

import com.gkreduction.data.FIELD_COUNTRY_LIST
import com.gkreduction.data.entity.CinemaResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface CinemaNetworkApi {

    @GET(FIELD_COUNTRY_LIST)
    fun getCinemaList(): Single<List<CinemaResponse>>

}
