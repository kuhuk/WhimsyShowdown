package dev.kuhuk.whimsyshowdown.ui.playScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.kuhuk.whimsyshowdown.MainViewModel
import dev.kuhuk.whimsyshowdown.R
import dev.kuhuk.whimsyshowdown.utils.champagnePink
import dev.kuhuk.whimsyshowdown.utils.darkPurple
import dev.kuhuk.whimsyshowdown.utils.interFamily

@Composable
fun PlayScreen() {
    val viewModel: PlayScreenViewModel = viewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = viewModel.chosenValueState.value.color
    ) {
        Column(
            modifier = Modifier.height(IntrinsicSize.Max)
        ) {
            val userScore = viewModel.scoreCardUIState.value.userScore
            val botScore = viewModel.scoreCardUIState.value.botScore
            val drawCount = viewModel.scoreCardUIState.value.drawCount
            ScoreCard(userScore.toString(), botScore.toString(), drawCount.toString())

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                val botChosenValue = viewModel.chosenValueState.value.botPickedValue
                val result = viewModel.chosenValueState.value.result
                if(botChosenValue != "") {
                    ShowResultDetails(botChosenValue, result)
                    viewModel.updateBotChosenValue("")
                } else {
                    viewModel.bringBgColorToDefault()
                    ChooseObject()
                }
            }
        }
    }
}

@Composable
fun ScoreCard(yourScore: String, botScore: String, drawCount: String) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "you: $yourScore",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 20.sp)
        Text(text = "draw: $drawCount",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 20.sp)
        Text(text = "bot: $botScore",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 20.sp)
    }
}

@Composable
fun ChooseObject() {
    val viewModel: PlayScreenViewModel = viewModel()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "choose",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 24.sp)

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val context = LocalContext.current
            Text(text = context.getString(R.string.rock_emoji),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 70.sp,
                modifier = Modifier
                    .clickable {
                        viewModel.updateUserChosenValue("rock")
                    })

            Text(text = context.getString(R.string.paper_emoji),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 70.sp,
                modifier = Modifier
                    .clickable {
                        viewModel.updateUserChosenValue("paper")
                    })

            Text(text = context.getString(R.string.scissor_emoji),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 70.sp,
                modifier = Modifier
                    .clickable {
                        viewModel.updateUserChosenValue("scissor")
                    })
        }
    }
}

@Composable
fun ShowResultDetails(botChosenValue: String, result: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Bot chose $botChosenValue",
            color = Color.Black,
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,)

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = result,
            color = Color.Black,
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,)
    }
}