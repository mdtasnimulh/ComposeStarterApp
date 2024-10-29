package com.tasnimulhasan.appname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tasnimulhasan.designsystem.theme.AppnameTheme
import com.tasnimulhasan.appname.ui.AppnameApp
import com.tasnimulhasan.appname.ui.rememberAppnameAppState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberAppnameAppState()
            AppnameTheme {
                AppnameApp(appState = appState)
            }
        }
    }
}