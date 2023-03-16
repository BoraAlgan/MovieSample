package com.example.moviesample.ui.popularmovies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesample.R
import com.example.moviesample.databinding.PopularMovieFragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PopularMovieDetailFragment: Fragment(R.layout.popular_movie_fragment_detail) {

    private val popularMovieFragmentDetailViewModel: PopularMovieDetailFragmentViewModel by viewModels()
    private lateinit var binding: PopularMovieFragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.popular_movie_fragment_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner



        val args = this.arguments
        val inputData = args?.get("idData")
        binding.detailedTextView.text = inputData.toString()
        println(inputData)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailedPicture
    }


}