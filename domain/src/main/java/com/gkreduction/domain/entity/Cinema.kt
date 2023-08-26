package com.gkreduction.domain.entity


data class Cinema(
    val name: String,
    val genres: ArrayList<String>,
    val year: Int,
    val country: String,
    val director: String,
    val actors: ArrayList<String>,
    val imageUrl: String,
    val description: String

)
