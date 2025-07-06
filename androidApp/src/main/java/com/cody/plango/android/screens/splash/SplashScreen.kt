package com.cody.plango.android.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cody.plango.android.common.components.theming.OceanBlue

@Composable
fun SplashScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = OceanBlue
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Plan Go",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        SplashScreen()
    }
}