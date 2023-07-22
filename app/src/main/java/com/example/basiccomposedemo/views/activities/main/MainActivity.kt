package com.example.basiccomposedemo.views.activities.main

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
import com.example.basiccomposedemo.views.activities.main.ui.theme.BasicComposeDemoTheme
import com.example.basiccomposedemo.views.activities.rowsAndColumns.RowsAndColumnsBasicsActivity

class MainActivity : ComponentActivity() {
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeDemoTheme {
                Surface(
                    modifier = Modifier.padding(20.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        GreetUser("Bittu")
                        Spacer(modifier = Modifier.size(0.dp, 20.dp))
                        GoToRowAndColumnBasicsActivity { goToRowsAndColumnsBasicActivity() }
                    }
                }
            }
        }
    }

    private fun goToRowsAndColumnsBasicActivity() {
        Intent(this, RowsAndColumnsBasicsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(this)
        }
    }
}

@ExperimentalUnitApi
@Composable
fun GreetUser(user: String) {
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
fun GoToRowAndColumnBasicsActivity(function: () -> Unit) {
    Button(
        onClick = { function.invoke() },
        modifier = Modifier.fillMaxWidth(),
        shape = CutCornerShape(10)
    ) {
        Text("Click Me")
    }
}
