package com.panzhiev.ui

import androidx.core.util.PatternsCompat

fun CharSequence?.isIpValid(): Boolean {
    return if (this == null) false
    else PatternsCompat.IP_ADDRESS.matcher(this).matches()
}
