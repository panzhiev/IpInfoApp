package com.panzhiev.ui.ip_info.viewmodel

import com.panzhiev.ui.base.Navigation

sealed class IpInfoNavigation : Navigation {

    object FetchIpInfoError : IpInfoNavigation()
}