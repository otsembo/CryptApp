package com.eeyan.cryptapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.eeyan.cryptapp.presentation.theme.CryptAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

