package com.example.moviesample.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.moviesample.R
import com.example.moviesample.data.remote.model.MovieResponseModel
import com.example.moviesample.databinding.ActivityMainBinding.bind
import com.example.moviesample.databinding.CardDesignBinding
import com.example.moviesample.databinding.PopularMovieFragmentBinding

@GlideModule
class MovieAdapter(private val mContext: Context,private val popularMovieList: List<MovieResponseModel>,private val listener: (MovieResponseModel) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.CardViewDesignHolder>() {

    @SuppressLint("CutPasteId")
    inner class CardViewDesignHolder(val binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener(popularMovieList[adapterPosition])
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)

        return CardViewDesignHolder(binding)
    }

        @SuppressLint("CheckResult")
        override fun onBindViewHolder(holder: CardViewDesignHolder, position: Int) {
            with(holder) {
                with(popularMovieList[position]) {
                    binding.movietitleTextView.text = originalTitle
                    binding.genreTextView.append(voteAverage.toString())
                    binding.durationTextView.append(originalLanguage)
                    binding.imdbTextView.append(releaseDate)

                    fun loadImage(url: String) {
                        Glide.with(binding.movieImageView)
                            .load(url+posterPath)
                            .transform(CircleCrop())
                            .into(binding.movieImageView)
                    }
                    loadImage("https://image.tmdb.org/t/p/w500")

                    val item = popularMovieList[position]
                    binding.rowCardView.setOnClickListener {
                        listener.invoke(item)

                    }


                }
            }
        }

    override fun getItemCount(): Int {
        return popularMovieList.size
    }

    }






