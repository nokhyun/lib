package com.example.testlib

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.nokhyunlib.setAuthorizationImage
import com.example.nokhyunlib.showSnackbar

class MainActivity : AppCompatActivity() {

    private val img: ImageView by lazy { findViewById(R.id.ivFakeImg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window?.decorView?.showSnackbar(
            msg = "Hello World",
            onDismiss = {
                log("onDismiss")
            }
        )

        img.setAuthorizationImage(
            url = "https://picsum.photos/id/237/200/300",
            token = "test",
            placeholderImg = R.drawable.ic_launcher_foreground,
            errorImg = R.drawable.ic_launcher_foreground,
            enabledLogging = true
        )
    }

    private fun log(msg: String) {
        Log.e(this.javaClass.simpleName, msg)
    }
}