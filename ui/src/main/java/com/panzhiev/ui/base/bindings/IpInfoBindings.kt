package com.panzhiev.ui.base.bindings

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.panzhiev.ui.R

object IpInfoBindings {

    @JvmStatic
    @BindingAdapter("isIpError")
    fun TextInputLayout.setIpError(isIpError: Boolean) {
        error = if (isIpError) {
            context.getString(R.string.ip_error)
        } else null
    }
}