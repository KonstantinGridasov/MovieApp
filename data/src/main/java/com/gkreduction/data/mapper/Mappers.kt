package com.gkreduction.data.mapper

import com.gkreduction.data.entity.MovieResponse
import com.gkreduction.domain.entity.Movie


fun mapListMovies(list: List<MovieResponse>): List<Movie> {
    val result = ArrayList<Movie>()
    list.forEach {
        result.add(it.toCoreModel())
    }
    return result
}

fun MovieResponse.toCoreModel(): Movie = Movie(
    name = this.name ?: "",
    genres = this.genres ?: emptyList(),
    year = this.year ?: 0,
    country = this.country ?: "",
    director = this.director ?: "",
    actors = this.actors ?: emptyList(),
    imageUrl = this.imageUrl ?: "",
    description = this.description ?: ""
)



