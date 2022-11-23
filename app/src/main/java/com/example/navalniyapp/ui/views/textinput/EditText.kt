package com.example.meetup.ui.views.textinput

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meetup.ui.theme.meetupTheme

@Composable
fun SingleStringEditText(
    title: String,
) {
    Box(
        modifier =
        Modifier
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))

        )
        Text(text = title)
    }
}

@Preview(showBackground = true, widthDp = 380, heightDp = 650)
@Composable
fun DefaultPreview() {
    meetupTheme {
        SingleStringEditText(title = "Field Name")
    }
}


