package com.example.basiccomposedemo.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.views.activities.ui.theme.BasicComposeDemoTheme

class MainActivity : ComponentActivity() {
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeDemoTheme {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AddGoToButton(
                        method = { changeActivity(IntroductionActivity::class.java) },
                        title = "Introduction"
                    )
                    AddGoToButton(
                        method = { changeActivity(RowsAndColumnsBasicsActivity::class.java) },
                        title = "Rows And Columns"
                    )
                    AddGoToButton(
                        method = { changeActivity(ModifiersDemoActivity::class.java) },
                        title = "Modifiers"
                    )
                    AddGoToButton(
                        method = { changeActivity(ImageCardDemoActivity::class.java) },
                        title = "Image Card"
                    )
                    AddGoToButton(
                        method = { changeActivity(TextStylingDemoActivity::class.java) },
                        title = "Text Styling"
                    )
                    AddGoToButton(
                        method = { changeActivity(StateDemoActivity::class.java) },
                        title = "State"
                    )
                }
            }
        }
    }

    private fun <T> changeActivity(kClass: Class<T>) {
        Intent(this@MainActivity, kClass).apply {
            startActivity(this)
        }
    }
}

@Composable
private fun AddGoToButton(method: () -> Unit, title: String) {
    Button(
        onClick = { method.invoke() },
    ) {
        Text(text = title)
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
    )
}