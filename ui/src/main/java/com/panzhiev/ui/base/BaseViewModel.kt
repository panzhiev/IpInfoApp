package com.panzhiev.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.panzhiev.domain.model.Result
import com.panzhiev.ui.base.extensions.event
import kotlinx.coroutines.Job

abstract class BaseViewModel<N : Navigation> : ViewModel() {

    private val navigationEvent = event<N>()

    fun observeNavigation(owner: LifecycleOwner, observer: (N) -> Unit) =
        navigationEvent.observe(owner, observer)

    protected fun navigateTo(navigation: N) = navigationEvent.postValue(navigation)

    protected inline fun <T> handleResult(
        result: Result<T>,
        onSuccess: (T) -> Unit = {},
        onError: (String?) -> Unit = {}
    ) {
        when (result) {
            is Result.Success -> onSuccess(result.data)
            is Result.Error -> onError(result.error)
        }
    }

    fun Job?.cancelIfActive() {
        if (this != null && isActive) cancel()
    }
}