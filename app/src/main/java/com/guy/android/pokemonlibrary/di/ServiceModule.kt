package com.guy.android.pokemonlibrary.di

import com.guy.android.pokemonlibrary.MoviesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Guy on 6/12/2019.
 */

@Module
object ServiceModule {

    @JvmStatic
    @Provides
    fun provideMoviesService(): MoviesService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(clientBuilder())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesService::class.java)
    }

    private fun clientBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url().newBuilder()
                    .addQueryParameter("api_key", "5a9ba2322fe328a52edc1aafd4c48d1f")
                    .build()

                val request = original.newBuilder().url(url).build()

                chain.proceed(request)
            }
            .build()

    }
}