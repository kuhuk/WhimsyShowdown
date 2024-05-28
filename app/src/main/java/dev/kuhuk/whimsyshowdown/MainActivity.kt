package dev.kuhuk.whimsyshowdown

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.kuhuk.whimsyshowdown.ui.theme.WhimsyShowdownTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhimsyShowdownTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.height(IntrinsicSize.Max)
                    ) {
                        viewModel = viewModel()
                        val userScore = viewModel.scoreCardUIState.value.userScore
                        val botScore = viewModel.scoreCardUIState.value.botScore
                        val drawCount = viewModel.scoreCardUIState.value.drawCount
                        ScoreCard(userScore.toString(), botScore.toString(), drawCount.toString())

                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            val botChosenValue = viewModel.chosenValueState.value.botPickedValue
                            if(botChosenValue != "") {
                                ShowResultDetails(botChosenValue)
                                viewModel.updateBotChosenValue("")
                            } else {
                                ChooseObject()
                            }
                        }
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
            Text(text = "you: $yourScore")
            Text(text = "draw: $drawCount")
            Text(text = "bot: $botScore")
        }
    }

    @Composable
    fun ChooseObject() {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "rock, paper, or scissor?")

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.rock),
                    contentDescription = "rock",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                        .clickable {
                            viewModel.updateUserChosenValue("rock")
                        }
                )

                Image(
                    painter = painterResource(R.drawable.paper),
                    contentDescription = "paper",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                        .clickable {
                            viewModel.updateUserChosenValue("paper")
                        }
                )

                Image(
                    painter = painterResource(R.drawable.scissor),
                    contentDescription = "scissor",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                        .clickable {
                            viewModel.updateUserChosenValue("scissor")
                        }
                )
            }
        }
    }
    
    @Composable
    fun ShowResultDetails(botChosenValue: String) {
        Column {
            Text(text = "Bot chose $botChosenValue")
        }
    }
}