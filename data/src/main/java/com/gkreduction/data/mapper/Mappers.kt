package com.gkreduction.data.mapper

import com.gkreduction.data.entity.CinemaResponse
import com.gkreduction.domain.entity.Cinema


fun mapListCinema(list: List<CinemaResponse>): List<Cinema> {
    val result = ArrayList<Cinema>()
    list.forEach {
        result.add(it.toCoreModel())
    }
    return result
}

fun CinemaResponse.toCoreModel(): Cinema = Cinema(
    name = this.name ?: "",
    genres = this.genres ?: emptyList(),
    year = this.year ?: 0,
    country = this.country ?: "",
    director = this.director ?: "",
    actors = this.actors ?: emptyList(),
    imageUrl = this.imageUrl ?: "",
    description = this.description ?: ""
)



