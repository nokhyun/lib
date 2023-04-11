package com.example.nokhyunlib

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun View.showSnackbar(
    msg: CharSequence,
    duration: Int = 2000,
    onShown: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
    actionText: String? = null,
    action: ((View) -> Unit)? = null
) {
    Snackbar.make(this, msg, duration)
        .setAction(actionText, action)
        .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
            override fun onShown(transientBottomBar: Snackbar?) {
                super.onShown(transientBottomBar)
                onShown?.invoke()
            }

            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                super.onDismissed(transientBottomBar, event)
                onDismiss?.invoke()
            }
        }).show()
}


