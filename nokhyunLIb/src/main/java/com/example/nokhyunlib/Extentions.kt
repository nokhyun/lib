package com.example.nokhyunlib

import android.content.Context
import android.widget.Toast

val test = "abc"

object AndroidKtx {

    fun String.showToast(context: Context) {
        Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
    }
}