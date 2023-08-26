package com.gkreduction.data.repository

import com.gkreduction.data.FIELD_COUNTRY_LIST
import com.gkreduction.data.entity.CinemaResponse
import retrofit2.http.GET

interface CinemaNetworkApi {

    @GET(FIELD_COUNTRY_LIST)
    suspend fun getCinemaList(): List<CinemaResponse>

}
