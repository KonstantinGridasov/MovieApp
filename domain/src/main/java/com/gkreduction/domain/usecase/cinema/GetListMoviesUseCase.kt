package com.gkreduction.domain.usecase.cinema

import com.gkreduction.domain.entity.Movie
import com.gkreduction.domain.repository.NetworkRepository
import com.gkreduction.domain.usecase.UseCase
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(private val repository: NetworkRepository) :
    UseCase<Any, List<Movie>> {

    override suspend fun execute(request: Any?): List<Movie> {
        return repository.getMovies()
    }

}