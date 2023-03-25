package com.example.moviesample.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

object Util {

    fun ImageView.loadImageDetail(url: String) {
        Glide.with(this)
            .load(url)
            .into(this)
    }

    fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .transform(CircleCrop())
            .into(this)
    }

}