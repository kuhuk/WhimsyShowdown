package dev.kuhuk.whimsyshowdown.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.kuhuk.whimsyshowdown.AppNavGraph
import dev.kuhuk.whimsyshowdown.ui.homePage.HomePage
import dev.kuhuk.whimsyshowdown.ui.theme.WhimsyShowdownTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhimsyShowdownTheme {
                AppNavGraph()
            }
        }
    }
}