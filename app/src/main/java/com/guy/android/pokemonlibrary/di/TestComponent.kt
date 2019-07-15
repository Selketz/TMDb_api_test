package com.guy.android.pokemonlibrary.di

import com.guy.android.pokemonlibrary.MoviesService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Guy on 6/13/2019.
 */

@Component(modules = [ServiceModule::class])
@Singleton
interface TestComponent {

    fun getPokemonService(): MoviesService

}