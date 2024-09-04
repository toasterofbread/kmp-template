package dev.toastbits.kmptemplate.application

import androidx.compose.ui.window.CanvasBasedWindow

fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        App()
    }
}
