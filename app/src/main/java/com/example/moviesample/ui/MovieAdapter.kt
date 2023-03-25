package com.example.moviesample.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.example.moviesample.data.remote.model.MovieResponseModel
import com.example.moviesample.databinding.CardDesignBinding
import com.example.moviesample.util.Util.loadImage

@GlideModule
class MovieAdapter(
    private val mContext: Context,
    private val popularMovieList: List<MovieResponseModel>,
    /*
    private val detailMovieList: List<BelongsToCollection>,
    private val listenerDetail: (BelongsToCollection) -> Unit,
    */

    private val listener: (MovieResponseModel) -> Unit
) : RecyclerView.Adapter<MovieAdapter.CardViewDesignHolder>() {

    @SuppressLint("CutPasteId")
    inner class CardViewDesignHolder(val binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
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
                with(binding) {
                    movietitleTextView.text = originalTitle
                    genreTextView.append(voteAverage.toString())
                    durationTextView.append(originalLanguage)
                    imdbTextView.append(releaseDate)
                    movieImageView.loadImage("https://image.tmdb.org/t/p/w500" + posterPath)

                    val item = popularMovieList[position]

                    rowCardView.setOnClickListener {
                        listener.invoke(item)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return popularMovieList.size
    }
}






