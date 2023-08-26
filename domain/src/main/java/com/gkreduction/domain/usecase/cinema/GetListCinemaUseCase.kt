package com.gkreduction.domain.usecase.cinema

import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.repository.NetworkRepository
import com.gkreduction.domain.usecase.UseCase
import javax.inject.Inject

class GetListCinemaUseCase @Inject constructor(private val repository: NetworkRepository) :
    UseCase<Any, List<Cinema>> {

    override suspend fun execute(request: Any?): List<Cinema> {
        return repository.fetchCinemaList()
    }

}