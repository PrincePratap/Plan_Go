package com.cody.plango.android.common.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.cody.plango.android.R






@Composable
fun StatItem(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally, // Center text horizontally
        verticalArrangement = Arrangement.Center // Center vertically within column
    ) {
        Text(
            text = label,
            fontSize = 15.sp, // Adjust font size as needed
            fontWeight = FontWeight.Medium, // Slightly bolder than normal
            color = Color.Black.copy(alpha = 0.8f) // Slightly muted black
        )
        Spacer(modifier = Modifier.height(6.dp)) // Space between label and value
        Text(
            text = value,
            fontSize = 26.sp, // Larger font size for the number
            fontWeight = FontWeight.Bold, // Bold number
            color = MaterialTheme.colorScheme.primary // Use theme's primary color (blue)
        )
    }
}




@Preview(showBackground = true, backgroundColor = 0xFF212121)
@Composable
fun UserProfileWithStatsPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Optional padding around the column
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(24.dp)) // Space between profile and stats

    }
}