package com.example.basiccomposedemo.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.utility.AddToMainButton

class ModifiersDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.padding(20.dp)) {
                AddToMainButton(this@ModifiersDemoActivity)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            color = colorResource(id = R.color.teal_200),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()
                        .height(100.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "Hello", color = colorResource(id = R.color.white))
                    Text(text = "World", color = colorResource(id = R.color.white))
                }
            }
        }
    }
}