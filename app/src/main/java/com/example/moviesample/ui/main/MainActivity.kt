package com.example.moviesample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.moviesample.R
import com.example.moviesample.databinding.ActivityMainBinding
import com.example.moviesample.ui.popularmovies.PopularMovieFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val popularMovieFragment = PopularMovieFragment()

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, popularMovieFragment).commit()





/*
        val popularMovieDetailFragment = PopularMovieDetailFragment()

        val fragmentManager2: FragmentManager = supportFragmentManager
        val fragmentTransaction2: FragmentTransaction = fragmentManager2.beginTransaction()
        fragmentTransaction2.replace(R.id.fragmentContainer, popularMovieDetailFragment).commit()
*/
    }
}
