package com.gkreduction.movieapp.ui

import com.gkreduction.domain.entity.Movie

data class MainScreenViewState(
    val items: List<Movie>? = null
)