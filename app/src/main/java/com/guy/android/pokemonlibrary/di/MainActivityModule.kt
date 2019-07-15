package com.guy.android.pokemonlibrary.di

import com.guy.android.pokemonlibrary.firstfragment.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Guy on 6/13/2019.
 */

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeFirstFragmentInjector(): FirstFragment

}