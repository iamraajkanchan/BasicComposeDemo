package com.example.basiccomposedemo.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.utility.AddToMainButton

class RowsAndColumnsBasicsActivity : ComponentActivity() {
    private val tealColor = Color(0xFF009688);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddToMainButton(this@RowsAndColumnsBasicsActivity)
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
            )
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
            }
        }
    }
}