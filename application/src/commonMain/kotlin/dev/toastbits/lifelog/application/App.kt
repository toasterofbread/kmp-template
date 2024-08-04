package dev.toastbits.kmptemplate.application

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.toastbits.kmptemplate.library.testFunc

@Composable
fun App() {
    Text("Hello World! " + testFunc())
}
