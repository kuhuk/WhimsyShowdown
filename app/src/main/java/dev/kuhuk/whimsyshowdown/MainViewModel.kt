package dev.kuhuk.whimsyshowdown

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _chosenValueState = mutableStateOf(ChosenValueState())
    private val _scoreCardUIState = mutableStateOf(ScoreCardUIState())

    val chosenValueState: State<ChosenValueState> = _chosenValueState
    val scoreCardUIState: State<ScoreCardUIState> = _scoreCardUIState

    private fun showBotValue() {
        _chosenValueState.value = _chosenValueState.value.copy(botPickedValue = pickBotValue())

        val userValue: String = _chosenValueState.value.userPickedValue
        val botValue: String = _chosenValueState.value.botPickedValue

        if(userValue == botValue) {
            var drawCount = _scoreCardUIState.value.drawCount
            _scoreCardUIState.value = _scoreCardUIState.value.copy(drawCount = ++drawCount)
            _chosenValueState.value = _chosenValueState.value.copy(winner = "It's a draw")
        } else if (userValue == "rock") {
            if (botValue == "paper") {
                var botScore = _scoreCardUIState.value.botScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(botScore = ++botScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "Bot won!")
            } else if (botValue == "scissor") {
                var userScore = _scoreCardUIState.value.userScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(userScore = ++userScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "You won!")
            }
        }  else if (userValue == "paper") {
            if (botValue == "rock") {
                var userScore = _scoreCardUIState.value.userScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(userScore = ++userScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "You won!")
            } else if (botValue == "scissor") {
                var botScore = _scoreCardUIState.value.botScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(botScore = ++botScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "Bot won!")
            }
        }   else if (userValue == "scissor") {
            if (botValue == "paper") {
                var userScore = _scoreCardUIState.value.userScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(userScore = ++userScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "You won!")
            } else if (botValue == "rock") {
                var botScore = _scoreCardUIState.value.botScore
                _scoreCardUIState.value = _scoreCardUIState.value.copy(botScore = ++botScore)
                _chosenValueState.value = _chosenValueState.value.copy(winner = "Bot won!")
            }
        }
    }

    fun updateUserChosenValue(value: String) {
        _chosenValueState.value = _chosenValueState.value.copy(userPickedValue = value)
        showBotValue()
    }

    fun updateBotChosenValue(value: String) {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            _chosenValueState.value = _chosenValueState.value.copy(botPickedValue = value)
        }, 1000)
    }

    private fun pickBotValue(): String {
        val words = arrayOf("rock", "paper", "scissor")
        return words.random()
    }

    data class ScoreCardUIState(
        val userScore: Int = 0,
        val botScore: Int = 0,
        val drawCount: Int = 0
    )

    data class ChosenValueState(
        val userPickedValue: String = "",
        val botPickedValue: String = "",
        val winner: String = ""
    )
}