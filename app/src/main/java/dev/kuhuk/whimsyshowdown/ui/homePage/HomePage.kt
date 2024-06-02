package dev.kuhuk.whimsyshowdown.ui.homePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.kuhuk.whimsyshowdown.utils.champagnePink
import dev.kuhuk.whimsyshowdown.utils.chineseViolet
import dev.kuhuk.whimsyshowdown.utils.darkPurple
import dev.kuhuk.whimsyshowdown.utils.interFamily

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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = onNavigateToPlayScreen,
                    colors = ButtonDefaults.buttonColors(containerColor = chineseViolet, contentColor = champagnePink),
                    shape = RoundedCornerShape(16)
                ) {
                    Text("Play RPS")
                }
            }
        }
    }
}

@Composable
fun Title() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = "Whimsy Showdown!",
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = chineseViolet
        )
    }
}