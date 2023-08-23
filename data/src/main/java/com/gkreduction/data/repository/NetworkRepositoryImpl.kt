package com.gkreduction.data.repository

import com.gkreduction.data.mapper.mapListCinema
import com.gkreduction.data.repository.datasource.NetworkDataSource
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.repository.NetworkRepository
import javax.inject.Inject
import  com.gkreduction.domain.entity.ResultData

class NetworkRepositoryImpl @Inject constructor(var dataSourceImpl: NetworkDataSource) :
    NetworkRepository {

    override suspend fun fetchCinemaList(): ResultData<List<Cinema>> =
        try {
            val response = dataSourceImpl.fetchCinemaList()
            if (response.isSuccessful && response.body() != null) {
                val data = mapListCinema(response.body()!!)
                ResultData.Success(data)
            } else {
                TODO("Error not Implemented")
//                throw Throwable("sss")
            }

        } catch (e: Exception) {
            throw e
        }


}

