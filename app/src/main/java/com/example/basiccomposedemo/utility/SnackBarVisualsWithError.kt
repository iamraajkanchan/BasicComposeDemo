package com.example.basiccomposedemo.utility

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals

class SnackBarVisualsWithError(override val message: String, val isError: Boolean) :
    SnackbarVisuals {
    override val actionLabel: String
        get() = if (isError) "Error" else message
    override val duration: SnackbarDuration
        get() = SnackbarDuration.Long
    override val withDismissAction: Boolean
        get() = false
}