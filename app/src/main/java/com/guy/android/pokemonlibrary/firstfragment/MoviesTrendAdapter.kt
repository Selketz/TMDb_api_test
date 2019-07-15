package com.guy.android.pokemonlibrary.firstfragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guy.android.pokemonlibrary.Movie
import com.guy.android.pokemonlibrary.MoviesDto
import com.guy.android.pokemonlibrary.R
import com.guy.android.pokemonlibrary.databinding.MovieViewBinding

/**
 * Created by Guy on 7/9/2019.
 */
class MoviesTrendAdapter(
    private val onClickListener: (Movie) -> Unit,
    private val pageLimitListener: () -> Unit) :
    ListAdapter<Movie, MoviesTrendAdapter.MoviesViewHolder>(MoviesTrendDiffCallback()) {

    init {
        Log.d("listadapter", "list adapter init")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
        if (position == currentList.size - 1) {
            pageLimitListener()
        }
    }

    fun submitList(movieData: MoviesDto) {
        val newList: MutableList<Movie> = if (currentList.isNotEmpty()) {
            currentList.toMutableList()
        } else {
            mutableListOf()
        }
        newList.addAll(movieData.results)
        submitList(newList)
    }

    class MoviesViewHolder(private val binding: MovieViewBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            const val BASE_URI = "https://image.tmdb.org/t/p/w500"
            fun from(parent: ViewGroup): MoviesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieViewBinding.inflate(layoutInflater, parent, false)
                return MoviesViewHolder(binding)
            }
        }

        fun bind(movie: Movie, onClickListener: (Movie) -> Unit) {
            Glide.with(binding.root)
                .load(BASE_URI + movie.poster)
                .placeholder(R.drawable.loading_spinner)
                .error(R.drawable.ic_error_black_24dp)
                .into(binding.imageView)
            binding.imageView.setOnClickListener {
                onClickListener(movie)
            }
            binding.textView.text = movie.title
        }
    }
}

class MoviesTrendDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

