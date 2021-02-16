package com.panzhiev.ui.base.bindings

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object ViewBindings {

    @JvmStatic
    @BindingAdapter("isVisible")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }
}