package com.example.basiccomposedemo.views.activities.rowsAndColumns

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.views.activities.main.MainActivity
import com.example.basiccomposedemo.views.activities.modifiers.ModifiersDemoActivity

class RowsAndColumnsBasicsActivity : ComponentActivity() {
    private val tealColor = Color(0xFF009688);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Image(
                painter = painterResource(id = R.drawable.icon_back_arrow),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(top = 5.dp, start = 5.dp)
                    .clickable { goToMainActivity() }
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth())
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
                    .background(colorResource(id = R.color.purple_200)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Rows",
                    color = Color.White,
                    modifier = Modifier
                        .width(100.dp)
                        .height(30.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "And",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    textAlign = TextAlign.Center
                )
                Text(text = "Columns", color = Color.White)
                Button(
                    onClick = { goToModifierActivity() },
                    shape = CutCornerShape(10.dp),
                    modifier = Modifier
                        .height(60.dp)
                        .padding(top = 20.dp)
                ) {
                    Text(text = "Go To Modifier")
                }
            }
        }
    }

    private fun goToModifierActivity() {
        Intent(this@RowsAndColumnsBasicsActivity, ModifiersDemoActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun goToMainActivity() {
        Intent(this@RowsAndColumnsBasicsActivity, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(this)
        }
    }
}