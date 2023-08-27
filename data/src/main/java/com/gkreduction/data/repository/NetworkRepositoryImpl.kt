package com.gkreduction.data.repository

import com.gkreduction.data.mapper.mapListMovies
import com.gkreduction.data.repository.datasource.NetworkDataSource
import com.gkreduction.domain.entity.Movie
import com.gkreduction.domain.repository.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(var dataSourceImpl: NetworkDataSource) :
    NetworkRepository {

    override suspend fun getMovies(): List<Movie> {
        val data = dataSourceImpl.fetchCinemaList()
        return if (data.isNotEmpty())
            mapListMovies(data)
        else emptyList()
    }

}
