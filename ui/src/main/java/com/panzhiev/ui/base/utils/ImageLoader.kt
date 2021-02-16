package com.panzhiev.ui.base.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(
    url: String?,
    options: RequestOptions? = null
) {
    val requestBuilder =
        Glide
            .with(context)
            .load(url)

    if (options != null) {
        requestBuilder.apply(options)
    }

    requestBuilder
        .transition(crossFade)
        .into(this)
}

private val crossFade by lazy {
    val factory = DrawableCrossFadeFactory.Builder()
        .setCrossFadeEnabled(true)
        .build()
    DrawableTransitionOptions().crossFade(factory)
}