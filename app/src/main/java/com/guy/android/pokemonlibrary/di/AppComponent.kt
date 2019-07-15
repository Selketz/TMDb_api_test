package com.guy.android.pokemonlibrary.di

import com.guy.android.pokemonlibrary.PokemonApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Guy on 6/13/2019.
 */

@Component(modules = [ActivityModule::class, AndroidInjectionModule::class])
@Singleton
interface AppComponent : AndroidInjector<PokemonApplication> {

//    @Component.Builder
//    interface Builder {
//
//        fun build(): AppComponent
//    }

}