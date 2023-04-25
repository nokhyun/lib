package com.example.testlib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.nokhyunlib.compose.FontSet
import com.example.nokhyunlib.compose.TextDp
import com.example.nokhyunlib.compose.textDp

class ComposeMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                /** TextDp Example */
                TextDp(
                    "HelloWorld",
                    fontSet = FontSet(
                        fontSize = 28.textDp,
                        fontFamily = FontFamily.Default
                    ),
                    fontWeight = FontWeight.Medium,
                )
            }

        }
    }
}