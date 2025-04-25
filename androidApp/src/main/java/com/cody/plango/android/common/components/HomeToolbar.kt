package com.cody.plango.android.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R
import com.dipumba.ytsocialapp.android.common.theming.whiteTheme

@Composable
fun  HomeToolbar(
    userName: String,
    avatarResId: Int, // Pass the drawable resource ID
    onUserClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Surface(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), // Optional padding
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserProfileChip(
                userName = userName,
                avatarResId = avatarResId,
                onClick = onUserClick
            )
            Spacer(modifier = Modifier.weight(1f)) // 👈 Pushes icon to right

            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications",
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onNotificationClick() }
            )

        }


    }
}


@Composable
fun UserProfileChip(
    userName: String,
    avatarResId: Int, // Pass the drawable resource ID
    modifier: Modifier = Modifier,
    onClick: () -> Unit

) {
    Surface(
        modifier = modifier
            .height(44.dp)
            .clickable { onClick() }, // Height from the image dimension hint
        shape = RoundedCornerShape(percent = 50), // Pill shape
        color = whiteTheme, // Explicit white background

        // You could use MaterialTheme.colorScheme.surface if it's white in your theme
    ) {
        Row(
            modifier = Modifier
                .padding(start = 4.dp, end = 16.dp), // Padding inside the chip (more on the right)
            verticalAlignment = Alignment.CenterVertically // Center items vertically
        ) {
            // Box for the pink background circle
            Box(
                modifier = Modifier
                    .size(36.dp) // Slightly smaller than chip height for padding
                    .clip(CircleShape) // Make it circular
                    .background(Color(0xFFFFE0E6)), // Light pink background color
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = avatarResId),
                    contentDescription = "$userName avatar",
                    contentScale = ContentScale.Crop, // Or Fit, depending on your asset
                    modifier = Modifier
                        .size(34.dp) // Image slightly smaller than pink circle or fillMaxSize()
                        .clip(CircleShape) // Clip the actual image to a circle
                )
            }

            Spacer(modifier = Modifier.width(8.dp)) // Space between image and text

            Text(
                text = userName,
                color = Color.Black, // Explicit black color for text
                // Use MaterialTheme.colorScheme.onSurface if appropriate
                fontSize = 18.sp, // Adjust size as needed
                fontFamily = FontFamily.Serif // Use Serif font family as it appears in the image
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2C2C2C) // Dark background for preview
@Composable
fun HomeToolbarPreview() {
    HomeToolbar(userName = "Cody Rajput", avatarResId =   R.drawable.rectangle_838, onUserClick = {}, onNotificationClick = {}) // Use your placeholder

}
