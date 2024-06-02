package dev.kuhuk.whimsyshowdown.ui.homePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import dev.kuhuk.whimsyshowdown.R
import dev.kuhuk.whimsyshowdown.utils.champagnePink
import dev.kuhuk.whimsyshowdown.utils.chineseViolet

@Composable
fun HomePage(
    onNavigateToPlayScreen: () -> Unit,
) {
    val viewModel: HomePageViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = champagnePink
    ) {
        Column(
            modifier = Modifier.height(IntrinsicSize.Max)
        ) {
            Title()
            Column(
                modifier = Modifier.height(IntrinsicSize.Max),
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = onNavigateToPlayScreen) {
                    Text("Play")
                }
            }
        }
    }
}

@Composable
fun Title() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Whimsy Showdown!",
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            fontSize = 24.sp,
            color = chineseViolet
        )
    }
}

@Composable
fun PlayButton() {
}