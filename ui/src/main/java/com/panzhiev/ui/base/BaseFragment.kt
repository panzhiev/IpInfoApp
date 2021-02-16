package com.panzhiev.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment<B : ViewDataBinding> : DaggerFragment() {

    protected lateinit var binding: B

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        setupBinding(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupViews()
    }

    abstract fun setupBinding(binding: B)

    protected open fun setupViewModel() = Unit

    abstract fun setupViews()

    protected fun showToast(message: CharSequence) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}