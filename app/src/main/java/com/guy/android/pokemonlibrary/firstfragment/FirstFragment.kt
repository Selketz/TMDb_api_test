package com.guy.android.pokemonlibrary.firstfragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.guy.android.pokemonlibrary.MoviesDto
import com.guy.android.pokemonlibrary.R
import com.guy.android.pokemonlibrary.databinding.FragmentFirstBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by Guy on 6/4/2019.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: FirstViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(FirstViewModel::class.java)
    }
    private lateinit var adapter: MoviesTrendAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        observeViewModel()
    }

    private fun setAdapter() {
        adapter = MoviesTrendAdapter(onClickListener = { movie ->
            this.findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToMovieDetailFragment(movie)
            )
        }, pageLimitListener = {
            viewModel.requestMorePage()
        })
    }

    private fun observeViewModel() {
        viewModel.moviesTrend.observe(this, Observer<MoviesDto> {
            if (it.results.isNotEmpty()) {
                adapter.submitList(it)
            }
        })

        viewModel.errorMessage.observe(this, Observer<String> {
            it?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        setViewModel()
        binding.moviesTrendRecyclerView.adapter = adapter
        viewModel.requestFirstPage()

        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}