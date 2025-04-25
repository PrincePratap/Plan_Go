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
fun UserProfile(
    @DrawableRes imageResId: Int,
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp), // Add padding around the whole element
        horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
        verticalArrangement = Arrangement.Center // Center vertically in the available space
    ) {
        // Box to handle the circular background color behind the image
        Box(
            modifier = Modifier
                .size(130.dp) // Size of the outer circle including background
                .background(
                    color = Color(0xFFFFE0E6), // Light pink background color from image
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center // Center the image inside the box
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "$name profile picture",
                contentScale = ContentScale.Crop, // Crop the image to fit
                modifier = Modifier
                    .size(120.dp) // Slightly smaller size for the actual image
                    .clip(CircleShape) // Clip the image itself to a circle
            )
        }

        Spacer(modifier = Modifier.height(20.dp)) // Space between image and name

        Text(
            text = name,
            fontSize = 32.sp, // Adjust font size as needed
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.87f) // Dark text color
        )

        Spacer(modifier = Modifier.height(4.dp)) // Smaller space between name and email

        Text(
            text = email,
            fontSize = 17.sp, // Adjust font size as needed
            color = Color.Gray // Gray color for email
        )
    }
}

@Composable
fun StatsCard() {
    Card(
        modifier = Modifier
            .widthIn(max = 500.dp) // Optional: constrain max width
            .padding(horizontal = 16.dp), // Add horizontal padding if needed outside the card
        shape = RoundedCornerShape(16.dp), // Adjust corner radius as needed
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Set background color to white
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Add slight elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Add padding inside the card, around the content
                .padding(vertical = 20.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround, // Distribute space evenly
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatItem(label = "Reward Points", value = "360")
            StatItem(label = "Travel Trips", value = "238")
            StatItem(label = "Bucket List", value = "473")
        }
    }
}

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
        UserProfile(
            imageResId = R.drawable.profile_avatar,
            name = "Leonardo",
            email = "leonardo@gmail.com"
        )
        Spacer(modifier = Modifier.height(24.dp)) // Space between profile and stats
        StatsCard()
    }
}