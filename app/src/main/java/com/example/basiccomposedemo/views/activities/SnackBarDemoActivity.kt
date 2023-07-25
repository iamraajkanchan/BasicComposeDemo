package com.example.basiccomposedemo.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.basiccomposedemo.utility.AddToMainButton
import com.example.basiccomposedemo.utility.SnackBarVisualsWithError
import kotlinx.coroutines.launch

class SnackBarDemoActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackBarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            var textFieldState by remember {
                mutableStateOf("")
            }
            Scaffold(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                snackbarHost = {
                    SnackbarHost(hostState = snackBarHostState) { data ->
                        val isError = (data.visuals as? SnackBarVisualsWithError)?.isError ?: false
                        val buttonColor = if (isError) {
                            ButtonDefaults.textButtonColors(
                                containerColor = MaterialTheme.colorScheme.errorContainer,
                                contentColor = MaterialTheme.colorScheme.error
                            )
                        } else {
                            ButtonDefaults.textButtonColors(
                                containerColor = MaterialTheme.colorScheme.inversePrimary
                            )
                        }
                        Snackbar(
                            modifier = Modifier
                                //.border(2.dp, MaterialTheme.colorScheme.secondary)
                                .padding(8.dp),
                            /*
                            action = {
                                TextButton(
                                    onClick = { if (isError) data.dismiss() else data.performAction() },
                                    colors = buttonColor
                                ) {
                                    // Text(text = data.visuals.actionLabel ?: "")
                                    // Text(text = data.visuals.actionLabel ?: "")
                                }
                            }
                            */
                        ) {
                            Text(text = data.visuals.message)
                        }
                    }
                }
            ) { contentPadding ->
                Column(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxWidth(),
                ) {
                    AddToMainButton(this@SnackBarDemoActivity)
                }
                Column(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    OutlinedTextField(
                        value = textFieldState,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        maxLines = 10,
                        label = {
                            Text(text = "Mobile Number")
                        },
                        onValueChange = {
                            textFieldState = it
                        })
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    SnackBarVisualsWithError(
                                        "Number $textFieldState is saved in the database",
                                        false
                                    )
                                )
                            }
                        }) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}

/**
* Reference:
* https://developer.android.com/reference/kotlin/androidx/compose/material3/SnackbarHostState
 *
* */

