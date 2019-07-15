package com.guy.android.pokemonlibrary.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guy.android.pokemonlibrary.MoviesDto
import com.guy.android.pokemonlibrary.MoviesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Guy on 6/12/2019.
 */
class FirstViewModel @Inject constructor(private val service: MoviesService) : ViewModel() {

    var errorMessage = MutableLiveData<String>()
    val moviesTrend = MutableLiveData<MoviesDto>()
    private var currentPage = 1
    private var totalPage = 2
    private var firstRequest = true

    fun requestMorePage() {
        if (++currentPage > totalPage) {
            errorMessage.value = "This is the last page."
            return
        }
        getTrendMovies()
    }

    fun requestFirstPage() {
        if (!firstRequest) {
            return
        }
        firstRequest = false
        getTrendMovies()
    }

    private fun getTrendMovies() {
        service.getTrendMovies(page = currentPage).enqueue(object : Callback<MoviesDto> {
            override fun onFailure(call: Call<MoviesDto>, t: Throwable) {
                errorMessage.value = t.toString()
            }

            override fun onResponse(call: Call<MoviesDto>, response: Response<MoviesDto>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    moviesTrend.value = body
                    totalPage = body.totalPages
                } else {
                    errorMessage.value = "error code = ${response.code()}"
                }
            }
        })
    }
}