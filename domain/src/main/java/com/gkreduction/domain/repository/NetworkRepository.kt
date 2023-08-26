package com.gkreduction.domain.repository

import com.gkreduction.domain.entity.Cinema
import io.reactivex.Observable
import io.reactivex.Single

interface NetworkRepository {
    fun fetchCinemaList(): Single<List<Cinema>>
}