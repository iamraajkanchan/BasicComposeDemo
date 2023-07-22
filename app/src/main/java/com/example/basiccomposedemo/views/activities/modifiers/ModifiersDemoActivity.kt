package com.example.basiccomposedemo.views.activities.modifiers

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.views.activities.imagecard.ImageCardDemoActivity
import com.example.basiccomposedemo.views.activities.rowsAndColumns.RowsAndColumnsBasicsActivity

class ModifiersDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.padding(20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.icon_back_arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .clickable { goToRowsAndColumnsActivity() }
                )
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
                    Button(onClick = { goToImageCardDemoActivity() }) {
                        Text(text = "Go To ImageCard")
                    }
                }
            }
        }
    }

    private fun goToRowsAndColumnsActivity() {
        Intent(this@ModifiersDemoActivity, RowsAndColumnsBasicsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(this)
        }
    }

    private fun goToImageCardDemoActivity() {
        Intent(this@ModifiersDemoActivity, ImageCardDemoActivity::class.java).apply {
            startActivity(this)
        }
    }
}