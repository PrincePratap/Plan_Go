package com.cody.plango.android.screens.user

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R
import com.cody.plango.android.common.components.CustomIcon
import com.cody.plango.android.common.components.CustomTextNormal
import com.cody.plango.android.common.components.StatItem

@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
    name: String,
    email: String,
    @DrawableRes imageResId: Int,
    onNavigateToEditProfile: () -> Unit = {},
    onNavigateToBookmarked: () -> Unit = {},
    onNavigateToPreviousTrips: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {},
    onNavigateToVersion: () -> Unit = {},

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        UserProfile(
            imageResId = imageResId,
            name = name,
            email = email
        )
        StatsCard()

        MenuItem(modifier = Modifier)
    }
}

@Composable
fun UserProfile(
    @DrawableRes imageResId: Int,
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(16.dp), // Add padding around the whole element
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
        Spacer(modifier = Modifier.height(24.dp))

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
fun MenuItem(modifier: Modifier) {

    Spacer(modifier = Modifier.height(24.dp))
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

        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                CustomIcon(modifier = Modifier.wrapContentSize(), R.drawable.ic_profile, "ProfileIcon")
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextNormal(modifier = Modifier, R.string.profile)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CustomIcon(modifier = Modifier.wrapContentSize(), R.drawable.ic_profile, "ProfileIcon")
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextNormal(modifier = Modifier,R.string.bookmarked)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CustomIcon(modifier = Modifier.wrapContentSize(), R.drawable.ic_profile, "ProfileIcon")
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextNormal(modifier = Modifier, R.string.previous_trips)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CustomIcon(modifier = Modifier.wrapContentSize(), R.drawable.ic_profile, "ProfileIcon")
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextNormal(modifier = Modifier, R.string.settings)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CustomIcon(modifier = Modifier.wrapContentSize(), R.drawable.ic_profile, "ProfileIcon")
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextNormal(modifier = Modifier, R.string.version)
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfileScreen() {
    UserProfileScreen(
        name = "Aditya Singh",
        email = "aditya@example.com",
        imageResId = R.drawable.profile_avatar // Replace with your drawable
    )
}