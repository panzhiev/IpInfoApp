package com.panzhiev.ui.base.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

@Suppress("unused")
fun <T> ViewModel.mutable(initial: T? = null): MutableLiveData<T> {
    return MutableLiveData<T>().apply {
        initial?.let { value = it }
    }
}

@Suppress("unused")
fun <T : Any> ViewModel.event() = LiveEvent<T>()
