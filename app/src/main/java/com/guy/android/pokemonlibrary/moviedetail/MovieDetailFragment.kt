package com.guy.android.pokemonlibrary.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guy.android.pokemonlibrary.databinding.FragmentMovieDetailBinding

/**
 * Created by Guy on 7/10/2019.
 */

class MovieDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val movieArgument = MovieDetailFragmentArgs.fromBundle(arguments!!).movieArgument

        binding.movie = movieArgument

        return binding.root
    }
}