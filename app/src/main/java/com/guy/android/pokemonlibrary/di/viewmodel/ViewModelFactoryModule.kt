package com.guy.android.pokemonlibrary.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Guy on 6/13/2019.
 */

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: PokemonViewModelFactory): ViewModelProvider.Factory
}