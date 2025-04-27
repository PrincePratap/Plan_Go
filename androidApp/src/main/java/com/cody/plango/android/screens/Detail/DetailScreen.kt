package com.cody.plango.android.screens.Detail


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R


@Composable
fun DetailScreen() {
    val scrollState = rememberScrollState()
    // Use a Box to allow drawing behind the status bar if needed,
    // and to easily set the dark background for the preview context.
//    Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 24.dp), // Add padding to push content down slightly from screen top edge
//            color = MaterialTheme.colorScheme.surface, // White background
//            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp) // Rounded top corners
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(scrollState) // Make content scrollable
//            ) {
//                // Image Section with Overlays
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp) // Adjust height as needed
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.alpes_image), // Your placeholder image
//                        contentDescription = "Coeurdes Alpes",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp, bottomStart = 16.dp, bottomEnd = 16.dp)) // Rounded corners for image
//                    )
//
//                    // Back Button
//                    IconButton(
//                        onClick = { /* TODO: Handle back navigation */ },
//                        modifier = Modifier
//                            .align(Alignment.TopStart)
//                            .padding(16.dp)
//                            .clip(RoundedCornerShape(12.dp))
//                            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)) // Semi-transparent white
//                            .size(40.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = MaterialTheme.colorScheme.onSurface // Black/dark icon
//                        )
//                    }
//
//                    // Favorite Button
//                    FloatingActionButton( // Using FAB for easy circular shape with elevation
//                        onClick = { /* TODO: Handle favorite toggle */ },
//                        shape = CircleShape,
//                        containerColor = MaterialTheme.colorScheme.surface, // White background
//                        contentColor = Color.Red, // Red heart
//                        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(16.dp)
//                            .size(50.dp) // Adjust size
//                    ) {
//                        Icon(
//                            imageVector = Icons.Filled.Favorite,
//                            contentDescription = "Favorite"
//                        )
//                    }
//                }
//
//                // Content Section below image
//                Column(
//                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
//                ) {
//                    // Title and Show Map Row
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.Top // Align items to the top of the row
//                    ) {
//                        // Title and Rating Column
//                        Column(modifier = Modifier.weight(1f)) {
//                            Text(
//                                text = "Coeurdes Alpes",
//                                style = MaterialTheme.typography.headlineSmall,
//                                fontWeight = FontWeight.Bold
//                            )
//                            Spacer(modifier = Modifier.height(4.dp))
//                            // Rating Row
//                            Row(verticalAlignment = Alignment.CenterVertically) {
//                                Icon(
//                                    imageVector = Icons.Default.Star,
//                                    contentDescription = "Rating",
//                                    tint = Color(0xFFFFC107), // Yellow star
//                                    modifier = Modifier.size(16.dp)
//                                )
//                                Spacer(modifier = Modifier.width(4.dp))
//                                Text(
//                                    text = "4.5 (355 Reviews)",
//                                    style = MaterialTheme.typography.bodyMedium,
//                                    color = MaterialTheme.colorScheme.onSurfaceVariant // Grayish text
//                                )
//                            }
//                        }
//                        // Show Map Button
//                        TextButton(
//                            onClick = { /* TODO: Show map action */ },
//                            contentPadding = PaddingValues(top = 4.dp) // Align baseline roughly with title
//                        ) {
//                            Text(
//                                text = "Show map",
//                                style = MaterialTheme.typography.bodyMedium,
//                                fontWeight = FontWeight.SemiBold,
//                                color = MaterialTheme.colorScheme.primary // Blue text
//                            )
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    // Description Text
//                    Text(
//                        text = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and ....",
//                        style = MaterialTheme.typography.bodyLarge,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Grayish text
//                        maxLines = 3, // Limit lines initially
//                        overflow = TextOverflow.Ellipsis
//                    )
//
//                    // Read More Row
//                    Row(
//                        modifier = Modifier
//                            // .clickable { /* TODO: Expand/collapse text */ } // Add click handler later
//                            .padding(vertical = 4.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = "Read more",
//                            style = MaterialTheme.typography.bodyLarge,
//                            fontWeight = FontWeight.SemiBold,
//                            color = MaterialTheme.colorScheme.primary // Blue text
//                        )
//                        Icon(
//                            imageVector = Icons.Default.KeyboardArrowDown,
//                            contentDescription = "Read More",
//                            tint = MaterialTheme.colorScheme.primary,
//                            modifier = Modifier.size(20.dp)
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    // Facilities Section
//                    Text(
//                        text = "Facilities",
//                        style = MaterialTheme.typography.titleMedium,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween // Space out facility items
//                    ) {
//                        sampleFacilities.forEach { facility ->
//                            FacilityItem(facility = facility)
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.height(24.dp)) // Space before bottom bar
//
//                } // End Content Column Padding
//
//                Spacer(modifier = Modifier.weight(1f)) // Push bottom bar down
//
//                // Bottom Bar (Price and Book Now)
//                Surface( // Add a surface for potential elevation/border later
//                    modifier = Modifier.fillMaxWidth(),
//                    shadowElevation = 4.dp // Add slight shadow/separation
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(MaterialTheme.colorScheme.surface) // Ensure white background
//                            .padding(horizontal = 20.dp, vertical = 16.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        // Price Column
//                        Column {
//                            Text(
//                                text = "Price",
//                                style = MaterialTheme.typography.bodyMedium,
//                                color = MaterialTheme.colorScheme.onSurfaceVariant
//                            )
//                            Text(
//                                text = "$199",
//                                style = MaterialTheme.typography.headlineMedium,
//                                fontWeight = FontWeight.Bold,
//                                color = Color(0xFF4CAF50) // Green color for price
//                            )
//                        }
//
//                        // Book Now Button
//                        Button(
//                            onClick = { /*TODO: Handle booking*/ },
//                            shape = RoundedCornerShape(12.dp),
//                            modifier = Modifier.height(50.dp),
//                            contentPadding = PaddingValues(horizontal = 24.dp) // Adjust padding
//                        ) {
//                            Text(
//                                text = "Book Now",
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.SemiBold
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                                contentDescription = null // Decorative
//                            )
//                        }
//                    }
//                }
//
//
//            } // End Main Content Column
//        } // End Main Surface
//    } // End Outer Box
}




//@Preview(showBackground = true, backgroundColor = 0xFF2C2C2C) // Dark gray background for context
//@Composable
//fun DetailScreenPreview() {
//    MyApplicationTheme {
//        DetailScreen()
//    }
//}

// Dummy Theme if you don't have one set up for preview
/*
@Composable
fun MyApplicationTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    MaterialTheme(
         colorScheme = if(darkTheme) darkColorScheme() else lightColorScheme(
             primary = Color(0xFF007AFF), // Example Blue
             background = Color.DarkGray,    // Background BEHIND the main Surface
             surface = Color.White,       // Background FOR the main Surface
             onBackground = Color.White,
             onSurface = Color.Black,
             onSurfaceVariant = Color.Gray,
             primaryContainer = Color(0xFFFFA500) // Example Orange
         ),
        typography = Typography(), // Define your typography if needed
        content = content
    )
}
*/