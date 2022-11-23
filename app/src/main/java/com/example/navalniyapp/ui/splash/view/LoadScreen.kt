package com.example.meetup.ui.splash.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.meetup.ui.splash.viewmodel.LoadViewModel
import com.example.meetup.ui.theme.DarkBlue
import com.example.meetup.ui.theme.meetupTheme

@Composable
fun LoadScreen(
    viewModel: LoadViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 100.dp),
            text = "MeetUp",
            fontSize = 28.sp,
            color = DarkBlue
        )
        Text(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(vertical = 80.dp),
            text = "Идет загрузка...",
            fontSize = 20.sp
        )
        CircularProgressIndicator(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)
        )
    }
    viewModel.uploadData()
}
@Preview(showBackground = true, widthDp = 380, heightDp = 650)
@Composable
fun DefaultPreview() {
    meetupTheme {
        LoadScreen(hiltViewModel())
    }
}