package com.gkreduction.movieapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesScreen(state = viewModel.state)
        }
        sendIntent(MainScreenIntent.LoadCinemaData)
    }



    private fun sendIntent(intent: MainScreenIntent) {
        lifecycleScope.launch { viewModel.intent.send(intent) }
    }
}