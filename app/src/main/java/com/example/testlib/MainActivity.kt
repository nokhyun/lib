package com.example.testlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.nokhyunlib.showSnackbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window?.decorView?.showSnackbar(
            msg = "Hello World",
            onDismiss = {
                log("onDismiss")
            }
        )
    }

    private fun log(msg: String){
        Log.e(this.javaClass.simpleName, msg)
    }
}