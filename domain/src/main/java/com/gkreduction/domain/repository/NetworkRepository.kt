package com.gkreduction.domain.repository

import com.gkreduction.domain.entity.Cinema

interface NetworkRepository {
    suspend fun fetchCinemaList(): List<Cinema>
}