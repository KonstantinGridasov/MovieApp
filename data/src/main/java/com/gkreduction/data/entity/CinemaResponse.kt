package com.gkreduction.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CinemaResponse(
    @SerialName("name") val name: String?,
    @SerialName("genres") val genres: ArrayList<String>?,
    @SerialName("year") val year: Int?,
    @SerialName("country") val country: String?,
    @SerialName("director") val director: String?,
    @SerialName("actors") val actors: ArrayList<String>?,
    @SerialName("image_url") val imageUrl: String?,
    @SerialName("description") val description: String?,
)
