package com.example.basiccomposedemo.views.activities.textStyling

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.views.activities.imagecard.ImageCardDemoActivity

class TextStylingDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.poppins_bold, FontWeight.Bold),
            Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_extra_light, FontWeight.ExtraLight)
        )
        setContent {
            Column(modifier = Modifier.padding(20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.icon_back_arrow),
                    contentDescription = "Back Arrow",
                    modifier = Modifier.clickable { goToImageCardDemoActivity() }
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color(0xED101010))
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(color = Color.Red, fontSize = 32.sp)
                            ) {
                                append("J")
                            }
                            append("etpack ")
                            withStyle(
                                style = SpanStyle(color = Color.Magenta, fontSize = 32.sp)
                            ) {
                                append("C")
                            }
                            append("ompose")
                        },
                        modifier = Modifier.padding(8.dp),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Button(onClick = { goToStateDemoActivity() }) {
                    Text(text = "Go To State Demo")
                }
            }
        }
    }

    private fun goToImageCardDemoActivity() {
        Intent(this@TextStylingDemoActivity, ImageCardDemoActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(this)
        }
    }

    private fun goToStateDemoActivity() {
        Toast.makeText(this@TextStylingDemoActivity, "Not implemented yet!", Toast.LENGTH_SHORT)
            .show()
    }
}