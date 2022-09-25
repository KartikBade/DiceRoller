package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerMain()
                }
            }
        }
    }
}

@Composable
fun DiceRollerMain() {
    var image by remember { mutableStateOf(R.drawable.ic_launcher_background) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null
        )
        Button(
            onClick = {
                image = when( (1..3).random() ) {
                    1 -> R.drawable.ic_launcher_foreground
                    2 -> R.drawable.ic_launcher_background
                    3 -> R.drawable.ic_launcher_foreground
                    else -> R.drawable.ic_launcher_background
                }
            },
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceRollerTheme {
        DiceRollerMain()
    }
}