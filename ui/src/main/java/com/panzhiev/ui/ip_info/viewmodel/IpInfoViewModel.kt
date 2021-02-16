package com.panzhiev.ui.ip_info.viewmodel

import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.panzhiev.domain.usecase.FetchIpInfoUseCase
import com.panzhiev.ui.base.BaseViewModel
import com.panzhiev.ui.base.extensions.mutable
import com.panzhiev.ui.base.extensions.withProgress
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class IpInfoViewModel @Inject constructor(
    private val fetchIpInfoUseCase: FetchIpInfoUseCase
) : BaseViewModel<IpInfoNavigation>() {

    val isProgress = mutable<Boolean>()
    val isIpError = mutable<Boolean>()

    val ipInfo = mutable<CharSequence>()
    private var ipQuery: CharSequence = ""

    private var searchJob: Job? = null

    fun onIpChanged(ip: CharSequence?) {
        ipQuery = ip ?: ""
        isIpError.postValue(false)
    }

    fun onSearchClicked() {
        searchJob.cancelIfActive()
        searchJob = viewModelScope.launch(IO) {
            withProgress(isProgress) {
                validateIp {
                    handleResult(
                        fetchIpInfoUseCase(ipQuery),
                        { ipInfo.postValue(it) },
                        { navigateTo(IpInfoNavigation.FetchIpInfoError) }
                    )
                }
            }
        }
    }

    private suspend fun validateIp(onDataValid: suspend () -> Unit) {

        val ipValid = Patterns.IP_ADDRESS.matcher(ipQuery).matches()
        isIpError.postValue(!ipValid)

        if (ipValid) {
            onDataValid()
        }
    }
}