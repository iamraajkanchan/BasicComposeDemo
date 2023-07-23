package com.example.basiccomposedemo.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.utility.AddToMainButton
import com.example.basiccomposedemo.views.activities.ui.theme.BasicComposeDemoTheme

class IntroductionActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeDemoTheme {
                Surface(
                    modifier = Modifier.padding(20.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AddToMainButton(this@IntroductionActivity)
                        GreetUser(user = "Bittu")
                        Spacer(modifier = Modifier.size(0.dp, 20.dp))
                        GoToRowAndColumnBasicsActivity { goToRowsAndColumnsBasicActivity() }
                    }
                }
            }
        }
    }

    private fun goToRowsAndColumnsBasicActivity() {
        Intent(this, RowsAndColumnsBasicsActivity::class.java).apply {
            startActivity(this)
        }
    }
}

@ExperimentalUnitApi
@Composable
private fun GreetUser(user: String) {
    Text(
        text = "Hello, $user",
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            color = Color.Blue,
            textAlign = TextAlign.Center,
            fontSize = TextUnit(24F, TextUnitType.Sp)
        )
    )
}

@Composable
private fun GoToRowAndColumnBasicsActivity(function: () -> Unit) {
    Button(
        onClick = { function.invoke() },
        modifier = Modifier.fillMaxWidth(),
        shape = CutCornerShape(10)
    ) {
        Text("Click Me")
    }
}