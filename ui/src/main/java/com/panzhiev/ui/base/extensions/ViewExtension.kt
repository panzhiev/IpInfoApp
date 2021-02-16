package com.panzhiev.ui.base.extensions

import android.view.View

fun View.setOnClickListenerWithDebounce(action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (System.currentTimeMillis() - lastClickTime < 700L) return
            else action()
            lastClickTime = System.currentTimeMillis()
        }
    })
}