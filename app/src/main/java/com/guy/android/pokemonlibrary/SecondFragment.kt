package com.guy.android.pokemonlibrary


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.guy.android.pokemonlibrary.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        binding.toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            when (checkedId) {
                R.id.first_button -> binding.someImage.setImageResource(R.drawable.ic_error_black_24dp)
                R.id.second_button -> binding.someImage.setImageResource(R.drawable.mad_max)
                R.id.third_button -> binding.someImage.setImageResource(R.drawable.ic_launcher_background)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }
}
