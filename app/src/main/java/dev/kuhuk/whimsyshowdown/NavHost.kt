package dev.kuhuk.whimsyshowdown

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.kuhuk.whimsyshowdown.ui.homePage.HomePage
import dev.kuhuk.whimsyshowdown.ui.playScreen.PlayScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        // add all destinations here
        composable(route = "home") { HomePage(onNavigateToPlayScreen = { navController.navigate("play_screen") },) }
        composable(route = "play_screen") { PlayScreen() }
    }
}