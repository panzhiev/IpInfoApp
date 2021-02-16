package com.panzhiev.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory<VIEW_MODEL : ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<VIEW_MODEL>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return viewModelProvider.get() as T
    }
}