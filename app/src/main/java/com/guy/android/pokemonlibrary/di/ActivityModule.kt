package com.guy.android.pokemonlibrary.di

import com.guy.android.pokemonlibrary.MainActivity
import com.guy.android.pokemonlibrary.di.viewmodel.ViewModelFactoryModule
import com.guy.android.pokemonlibrary.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Guy on 6/13/2019.
 */

@Module(includes = [ServiceModule::class, ViewModelFactoryModule::class, ViewModelModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity

}