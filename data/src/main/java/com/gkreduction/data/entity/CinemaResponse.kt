package com.gkreduction.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CinemaResponse(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("genres")
    val genres: ArrayList<String>,

    @Expose
    @SerializedName("year")
    val year: Int,

    @Expose
    @SerializedName("country")
    val country: String,

    @Expose
    @SerializedName("director")
    val director: String,

    @Expose
    @SerializedName("actors")
    val actors: ArrayList<String>,

    @Expose
    @SerializedName("image_url")
    val imageUrl: String,

    @Expose
    @SerializedName("description")
    val description: String,
)
