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
import com.example.moviesample.ui.popularmovies.PopularMovieFragment
import com.example.moviesample.util.Util.loadImageDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMovieDetailFragment : Fragment(R.layout.popular_movie_fragment_detail) {

    private val popularMovieFragmentDetailViewModel: PopularMovieDetailFragmentViewModel by viewModels()
    private lateinit var binding: PopularMovieFragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.popular_movie_fragment_detail,
                container,
                false
            )
        binding.lifecycleOwner = viewLifecycleOwner

        fun fetchInputData() {
            val args = this.arguments
            val inputData = args?.getInt("idData")
            if (inputData != null) {
                popularMovieFragmentDetailViewModel.getDetailsMovies(inputData)
            }
        }

        fetchInputData()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun observeMovieDetails() {
            with(binding) {
                popularMovieFragmentDetailViewModel.liveDataDetails.observe(viewLifecycleOwner) {
                    movieBackdrop.loadImageDetail("https://image.tmdb.org/t/p/w500" + it?.backdrop_path)
                    moviePoster.loadImageDetail("https://image.tmdb.org/t/p/w500" + it?.poster_path)
                    movieOverview.text = it?.overview
                    movieTitle.text = it?.title
                    movieReleaseDate.text = it?.release_date
                    durationTime.append(it?.runtime.toString())
                    durationTime.text = it?.runtime.toString() + "  min"
                }
            }
        }

        fun handleOnBackPressed() {
            with(binding) {
                goBackButton.setOnClickListener {
                    val popularMovieFragment = PopularMovieFragment()
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainer, popularMovieFragment)
                        ?.commit()
                }
            }
        }
        handleOnBackPressed()
        observeMovieDetails()
    }
}


