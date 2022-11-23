package com.example.meetup.ui.auth.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meetup.ui.theme.meetupTheme

@Composable
fun SignUpScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

    }
}

@Preview(showBackground = true, widthDp = 380, heightDp = 650)
@Composable
fun SignUpScreenPreview() {
    meetupTheme {
        SignUpScreen()
    }
}