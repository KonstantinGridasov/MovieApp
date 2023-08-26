package com.gkreduction.data.repository

import com.gkreduction.data.mapper.mapListCinema
import com.gkreduction.data.repository.datasource.NetworkDataSource
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.repository.NetworkRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(var dataSourceImpl: NetworkDataSource) :
    NetworkRepository {

    override fun fetchCinemaList(): Single<List<Cinema>> {
        return dataSourceImpl.fetchCinemaList()
            .map {
                mapListCinema(it)
            }
    }


}

