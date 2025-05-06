package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                DiceRoller()
            }
        }
    }
}

@Composable
fun DiceRoller() {
    var diceResult by remember { mutableStateOf(1) }
    val imageResource = when (diceResult) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = "Dice")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { diceResult = Random.nextInt(1, 7) }) {
            Text("Roll Dice")
        }
    }
}
