package com.example.basiccomposedemo.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.utility.AddToMainButton
import com.example.basiccomposedemo.views.activities.ui.theme.BasicComposeDemoTheme
import kotlin.random.Random

class StateDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val color = remember {
                        mutableStateOf(Color.Yellow)
                    }
                    AddToMainButton(this@StateDemoActivity)
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    AddColouredBox() {
                        color.value = it
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = color.value)
                    )
                }
            }
        }
    }
}

@Composable
private fun AddColouredBox(function: (Color) -> Unit) {
    val boxColor = remember {
        mutableStateOf(Color.Cyan)
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .background(color = boxColor.value)
        .clickable {
            val randomColor = Color(
                Random.nextFloat(), Random.nextFloat(), Random.nextFloat()
            )
            boxColor.value = randomColor
            function(randomColor)
        })
}