package com.tuusuario.myactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tuusuario.myactivity.presentation.ui.TaskListScreen
import com.tuusuario.myactivity.ui.theme.MyActivityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyActivityTheme {
                TaskListScreen()
            }
        }
    }
}
