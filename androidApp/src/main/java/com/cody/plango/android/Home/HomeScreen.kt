package com.cody.plango.android.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cody.plango.android.R


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.common.components.HomeToolbar

// Assume you have a basic Material 3 theme

// Data class for Destination item
data class Destination(
    val id: Int,
    val name: String,
    val location: String,
    val rating: Float,
    val imageUrl: Int, // Drawable resource ID
    val visitors: List<Int>, // Drawable resource IDs for avatars
    val visitorCount: Int
)

// Sample Data
val sampleDestinations = listOf(
    Destination(
        id = 1,
        name = "Niladri Reservoir",
        location = "Tekergat, Sunamgnj",
        rating = 4.7f,
        imageUrl = R.drawable.rectangle_838, // Use your placeholder
        visitors = listOf(R.drawable.rectangle_838, R.drawable.rectangle_838, R.drawable.rectangle_838), // Use placeholders
        visitorCount = 50
    ),
    Destination(
        id = 2,
        name = "Darma Reservoir", // Example name
        location = "Darma, Location", // Example location
        rating = 4.5f, // Example rating
        imageUrl = R.drawable.rectangle_838, // Use your placeholder
        visitors = listOf(R.drawable.rectangle_838, R.drawable.rectangle_838), // Use placeholders
        visitorCount = 30 // Example count
    )
    // Add more destinations if needed
)




@Composable
fun HomeScreen(userName: String, destinations: List<Destination>) {
    // The main content area with white background and rounded top corners
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background, // Should be white in your theme for this screen
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp) // Rounded top corners
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp) // Overall padding
        ) {
            // Top Row: User Chip and Notification Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeToolbar(userName = userName, avatarResId = R.drawable.rectangle_838, onUserClick = {}, onNotificationClick = {}) // Reuse UserChip

                // Notification Icon Button
                IconButton(
                    onClick = { /* TODO: Handle notification click */ },
                    modifier = Modifier
                        .size(40.dp) // Adjust size as needed
                        .clip(CircleShape)
                        .background(Color(0xFFF3F4F6)) // Light gray background for icon button
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.Black // Or MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Headline Text
            Text(
                text = buildAnnotatedString {
                    append("Explore the\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Beautiful ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFA500) // Orange color
                            // Note: The underline swoosh is complex; using simple styling here
                        )
                    ) {
                        append("world!")
                    }
                },
                style = MaterialTheme.typography.headlineLarge, // Adjust style as needed
                lineHeight = 40.sp // Adjust line height for spacing
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Best Destination Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Best Destination",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = { /* TODO: Handle View All click */ }) {
                    Text(
                        text = "View all",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary // Use theme's primary color
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Destination Cards List
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between cards
                contentPadding = PaddingValues(bottom = 16.dp) // Padding at the bottom if needed
            ) {
                items(destinations) { destination ->
                    DestinationCard(destination = destination)
                }
            }
        }
    }
}




// Composable for the Destination Card
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationCard(destination: Destination) {
    Card(
        onClick = { /* TODO: Handle card click */ },
        modifier = Modifier.width(240.dp), // Set a width for the card
        shape = RoundedCornerShape(16.dp), // Rounded corners for the card
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // White background
        // elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Optional elevation
    ) {
        Column {
            // Image section with bookmark icon
            Box(
                modifier = Modifier
                    .height(180.dp) // Fixed height for the image part
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = destination.imageUrl),
                    contentDescription = destination.name,
                    contentScale = ContentScale.Crop, // Crop to fill the bounds
                    modifier = Modifier.fillMaxSize()
                )
                // Bookmark Icon Button (Top End)
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.Black.copy(alpha = 0.3f)), // Semi-transparent background
                    contentAlignment = Alignment.Center
                ) {
//                    Icon(
//                        imageVector = Icons.Default.rectangle_838,
//                        contentDescription = "Bookmark",
//                        tint = Color.White,
//                        modifier = Modifier.size(18.dp)
//                    )
                }
            }

            // Text and Info section
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                // Name and Rating Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = destination.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f), // Take available space
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107), // Yellow star color
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = destination.rating.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Location Row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant, // Grayish tint
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = destination.location,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Visitor Avatars Row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Simple Avatar Stack (non-overlapping)
                    destination.visitors.take(3).forEach { avatarResId -> // Show max 3 avatars
                        Image(
                            painter = painterResource(id = avatarResId),
                            contentDescription = "Visitor",
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .padding(end = 4.dp) // Spacing between simple avatars
                        )
                    }
                    // Overlapping Avatar stack is more complex, needs Box with offset modifiers

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "+${destination.visitorCount}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


// Preview Composable
@Preview(showBackground = true, backgroundColor = 0xFF333333) // Dark background like original context
@Composable
fun HomeScreenPreview() {
        // The screen itself has a white background defined in its Surface
        Box(modifier=Modifier.fillMaxSize()) { // Added Box to constrain the preview
            HomeScreen(userName = "Leonardo", destinations = sampleDestinations)
        }

}


