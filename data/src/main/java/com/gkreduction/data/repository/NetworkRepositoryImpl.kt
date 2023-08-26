package com.gkreduction.data.repository

import com.gkreduction.data.mapper.mapListCinema
import com.gkreduction.data.repository.datasource.NetworkDataSource
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(var dataSourceImpl: NetworkDataSource) :
    NetworkRepository {

    override suspend fun fetchCinemaList(): List<Cinema> {
        val data = dataSourceImpl.fetchCinemaList()
        return if (data.isNotEmpty())
            mapListCinema(data)
        else emptyList()
    }

}
