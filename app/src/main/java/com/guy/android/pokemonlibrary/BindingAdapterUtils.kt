package com.guy.android.pokemonlibrary

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Guy on 7/11/2019.
 */
const val baseUri = "https://image.tmdb.org/t/p/w780"
@BindingAdapter("loadImage")
fun ImageView.loadImage(uri: String){
    Glide.with(this.context)
        .load(baseUri + uri)
        .placeholder(R.drawable.loading_spinner)
        .error(R.drawable.ic_error_black_24dp)
        .into(this)
}