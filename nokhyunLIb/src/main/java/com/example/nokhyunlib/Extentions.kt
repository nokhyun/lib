package com.example.nokhyunlib

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.view.doOnAttach
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

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

/**
 * Authorization image using coil library
 * @param url: image url
 * @param token: bearer token
 * @param placeholderImg: placeholder
 * @param errorImg: error
 * @param enabledLogging: true if logging is required
 *
 * https://coil-kt.github.io/coil/
 * Copyright 2023 Coil Contributors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * https://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
fun ImageView.setAuthorizationImage(
    url: String,
    token: String,
    @DrawableRes placeholderImg: Int,
    @DrawableRes errorImg: Int,
    enabledLogging: Boolean = false
) {
    if (token.isBlank()) throw IllegalArgumentException("Token is empty. Please enter your token.")

    this.doOnAttach {
        val imageLoader = ImageLoader.Builder(this.context).apply {
            if (enabledLogging) {
                this.okHttpClient {
                    OkHttpClient.Builder()
                        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        })
                        .build()
                }
            }
        }.build()

        val request = ImageRequest.Builder(context)
            .data(url)
            .setHeader("Authorization", "Bearer ".plus(token))
            .placeholder(placeholderImg)
            .error(errorImg)
            .target(this)
            .build()

        it.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
            imageLoader.execute(request)
        }
    }
}


