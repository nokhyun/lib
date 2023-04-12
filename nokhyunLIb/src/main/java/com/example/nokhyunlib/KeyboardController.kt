package com.example.nokhyunlib

import android.view.View
import android.view.WindowInsetsAnimation.Callback.DISPATCH_MODE_STOP
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Created by Nokhyun on 2023-04-12
 * */
interface KeyboardController {
    val isShowing: Boolean
    fun callback(onShowing: (() -> Unit)?, onDismiss: (() -> Unit)?)
}

class KeyboardControllerImpl(
    private val view: View
) : KeyboardController {

    private var prepareBottom: Int = 0
    private var endBottom: Int = 0

    private var _isShowing: Boolean = false
    override val isShowing: Boolean get() = _isShowing

    override fun callback(onShowing: (() -> Unit)?, onDismiss: (() -> Unit)?) {
        ViewCompat.setWindowInsetsAnimationCallback(
            view,
            object : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_STOP) {
                override fun onProgress(insets: WindowInsetsCompat, runningAnimations: MutableList<WindowInsetsAnimationCompat>): WindowInsetsCompat = insets
                override fun onPrepare(animation: WindowInsetsAnimationCompat) {
                    super.onPrepare(animation)

                    prepareBottom = view.bottom
                }

                override fun onEnd(animation: WindowInsetsAnimationCompat) {
                    super.onEnd(animation)

                    _isShowing = if (animation.typeMask == WindowInsetsCompat.Type.ime() && !isShowing) {
                        endBottom = view.bottom
                        onShowing?.invoke()
                        true
                    } else {
                        onDismiss?.invoke()
                        false
                    }
                }
            }
        )
    }
}