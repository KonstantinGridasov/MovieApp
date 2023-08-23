package com.gkreduction.domain.repository
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.entity.ResultData

interface NetworkRepository {
    suspend fun fetchCinemaList(): ResultData<List<Cinema>>
}