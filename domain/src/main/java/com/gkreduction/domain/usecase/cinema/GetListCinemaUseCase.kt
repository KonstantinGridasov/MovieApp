package com.gkreduction.domain.usecase.cinema

import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.repository.NetworkRepository
import com.gkreduction.domain.usecase.UseCase
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetListCinemaUseCase @Inject constructor(private val repository: NetworkRepository) :
    UseCase<Any, Single<List<Cinema>>> {

    override fun execute(request: Any?): Single<List<Cinema>> {
        return repository.fetchCinemaList()
    }

}