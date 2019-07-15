package com.guy.android.pokemonlibrary.di.viewmodel

import androidx.lifecycle.ViewModel
import com.guy.android.pokemonlibrary.firstfragment.FirstViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Guy on 6/13/2019.
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindFirstViewModel(firstViewModel: FirstViewModel): ViewModel

}