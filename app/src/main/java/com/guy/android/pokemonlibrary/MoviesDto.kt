package com.guy.android.pokemonlibrary

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Guy on 6/11/2019.
 */
data class MoviesDto(
    val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int
)

@Parcelize
data class Movie(
    val id: Int = -1,
    val title: String = "empty",
    @SerializedName("poster_path") val poster: String = "",
    @SerializedName("adult") val isAdultRate: Boolean = false,
    val overview: String = "",
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("genre_ids") val genreList: List<Int> = listOf(),
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("backdrop_path") val backDropPath: String = "",
    val popularity: Double = 0.0,
    @SerializedName("vote_count") val voteCount: Int = -1,
    @SerializedName("vote_average") val voteAverage: Double = 0.0
) : Parcelable