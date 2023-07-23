package com.example.basiccomposedemo.utility

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.basiccomposedemo.R
import com.example.basiccomposedemo.views.activities.MainActivity

private fun goBackToMainActivity(activity: ComponentActivity) {
    Intent(activity, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(this)
    }
}

@Composable
fun AddToMainButton(activity: ComponentActivity) {
    Image(
        painter = painterResource(id = R.drawable.icon_back_arrow),
        contentDescription = "Back Arrow",
        modifier = Modifier.clickable { goBackToMainActivity(activity) })
}