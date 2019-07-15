package com.guy.android.pokemonlibrary

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Guy on 6/11/2019.
 */
interface MoviesService {

    @GET("trending/{media_type}/{time_window}")
    fun getTrendMovies(
        @Path("media_type") type: String = "movie",
        @Path("time_window") time: String = "week",
        @Query("page") page: Int
        ) : Call<MoviesDto>

}