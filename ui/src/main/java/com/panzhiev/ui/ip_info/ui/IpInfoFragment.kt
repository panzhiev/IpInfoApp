package com.panzhiev.ui.ip_info.ui

import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import com.panzhiev.ui.R
import com.panzhiev.ui.base.BaseFragment
import com.panzhiev.ui.base.ViewModelFactory
import com.panzhiev.ui.databinding.FragmentIpInfoBinding
import com.panzhiev.ui.ip_info.viewmodel.IpInfoNavigation
import com.panzhiev.ui.ip_info.viewmodel.IpInfoViewModel
import javax.inject.Inject

class IpInfoFragment : BaseFragment<FragmentIpInfoBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<IpInfoViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(IpInfoViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_ip_info

    override fun setupBinding(binding: FragmentIpInfoBinding) {
        binding.vm = viewModel
    }

    override fun setupViewModel() {
        viewModel.observeNavigation(this) { navigateTo(it) }
    }

    override fun setupViews() {
        binding.ipEt.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.onSearchClicked()
                true
            } else false
        }
    }

    private fun navigateTo(navigation: IpInfoNavigation) {
        when (navigation) {
            IpInfoNavigation.FetchIpInfoError ->
                showToast(getString(R.string.common_error))
        }
    }
}