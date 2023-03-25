package com.example.moviesample.ui.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesample.R
import com.example.moviesample.databinding.PopularMovieFragmentBinding
import com.example.moviesample.ui.MovieAdapter
import com.example.moviesample.ui.popularmovies.detail.PopularMovieDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMovieFragment : Fragment(R.layout.popular_movie_fragment) {

    private val popularMovieFragmentViewModel: PopularMovieFragmentViewModel by viewModels()
    private lateinit var binding: PopularMovieFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.popular_movie_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        popularMovieFragmentViewModel.liveData.observe(viewLifecycleOwner) {
            binding.rv.adapter = MovieAdapter(requireContext(), it) {
                println(it.id.toString())
                val popularMovieDetailFragment = PopularMovieDetailFragment()
                val bundle = Bundle()
                bundle.putInt("idData", it.id)
                val fragment = popularMovieDetailFragment
                fragment.arguments = bundle
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentContainer, popularMovieDetailFragment)?.commit()
            }
        }

        binding.rv.apply {
            binding.rv.layoutManager = LinearLayoutManager(requireContext())
            binding.rv.setHasFixedSize(true)
        }


    }


}




