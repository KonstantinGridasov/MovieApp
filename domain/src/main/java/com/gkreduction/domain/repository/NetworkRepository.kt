package com.gkreduction.domain.repository

import com.gkreduction.domain.entity.Movie

interface NetworkRepository {
    suspend fun getMovies(): List<Movie>
}