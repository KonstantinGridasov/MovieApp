package com.gkreduction.domain.entity


data class Cinema(
    val name: String,
    val genres: List<String>,
    val year: Int,
    val country: String,
    val director: String,
    val actors: List<String>,
    val imageUrl: String,
    val description: String

)
