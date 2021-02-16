package com.panzhiev.ui.base.utils

import android.content.Context
import android.util.DisplayMetrics
import androidx.annotation.Px

@Px
fun Context.dpToPx(dp: Float) =
    (dp * (resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()

fun Context.pxToDp(@Px px: Int): Float =
    px / (resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)