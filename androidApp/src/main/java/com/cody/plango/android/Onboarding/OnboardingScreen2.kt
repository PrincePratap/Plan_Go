package com.cody.plango.android.Onboarding


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Replace with your actual drawable resource ID
// R.drawable.onboarding_image_2
val placeholderOnboardingImageId_2 = android.R.drawable.ic_dialog_map // Placeholder for preview

// Define the specific blue and orange colors from the image
val OnboardingButtonBlue = Color(0xFF007AFF) // Approximate blue from image
val OnboardingTextOrange = Color(0xFFFFA500) // Standard orange, adjust if needed



@Composable
fun OnboardingScreen2() {
    // Use Box to allow overlaying Skip button and handle system bars padding
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Base background
            .systemBarsPadding() // Handles status and navigation bar insets
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top section containing the main image and skip button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f) // Allocate ~60% height for the image area
            ) {
                Image(
                    // *** IMPORTANT: Replace with your actual image resource ***
                    painter = painterResource(id = placeholderOnboardingImageId_2),
                    contentDescription = "Onboarding landscape with canoe",
                    contentScale = ContentScale.Crop, // Crop image to fill the bounds
                    modifier = Modifier.fillMaxSize() // Image fills this Box
                )

                // Skip Button aligned to the top right corner
                TextButton(
                    onClick = { /* TODO: Implement skip action */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd) // Position top-right
                        .padding(top = 16.dp, end = 16.dp) // Padding from the edges
                ) {
                    Text("Skip", color = Color.White, fontSize = 16.sp) // White text for visibility
                }
            }

            // Bottom section with white background, rounded top corners
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Takes up remaining vertical space
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp), // Rounded top
                color = MaterialTheme.colorScheme.surface // Typically white
            ) {
                // Column for content within the white Surface
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 24.dp), // Inner padding
                    horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                ) {
                    // Title Text using AnnotatedString for styling "explore"
                    Text(
                        text = buildAnnotatedString {
                            append("It's a big world out\nthere go ") // Add line break for layout
                            withStyle(style = SpanStyle(
                                color = OnboardingTextOrange, // Orange color for "explore"
                                fontWeight = FontWeight.Bold) // Bold weight for "explore"
                            ) {
                                append("explore")
                            }
                            // Note: The curved underline under "explore" is complex and
                            // would typically require Canvas drawing or a custom background.
                            // It's not included in this standard implementation.
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold, // Bold for the whole title
                        textAlign = TextAlign.Center, // Center align text
                        lineHeight = 32.sp, // Adjust spacing between lines
                        color = MaterialTheme.colorScheme.onSurface // Default text color on surface
                    )

                    Spacer(modifier = Modifier.height(16.dp)) // Space below title

                    // Subtitle Text
                    Text(
                        text = "To get the best of your adventure you just need to leave and go where you like. we are waiting for you",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Gray // Muted color for subtitle
                    )

                    Spacer(modifier = Modifier.height(32.dp)) // Space below subtitle

                    // Pager Indicator (Showing page 2 of 3, index 1)
                    PagerIndicator(currentPage = 1, pageCount = 3)

                    Spacer(modifier = Modifier.weight(1f)) // Push content below (button) down

                    // Next Button
                    Button(
                        onClick = { /* TODO: Implement next action */ },
                        modifier = Modifier
                            .fillMaxWidth() // Button spans full width
                            .height(50.dp), // Fixed button height
                        shape = RoundedCornerShape(12.dp), // Rounded button corners
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OnboardingButtonBlue // Use the defined blue color
                        )
                    ) {
                        Text("Next", fontSize = 16.sp, color = Color.White) // White button text
                    }
                    Spacer(modifier = Modifier.height(16.dp)) // Space below button before edge
                }
            }
        }
    }
}

/**
 * A composable function to display a pager indicator with dots.
 * The current page's dot is wider and uses a different color.
 *
 * @param currentPage The index of the currently selected page (0-based).
 * @param pageCount The total number of pages.
 */
@Composable
fun PagerIndicator(currentPage: Int, pageCount: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Spacing between the dots
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage
            Box(
                modifier = Modifier
                    .size(width = if (isSelected) 20.dp else 8.dp, height = 8.dp) // Selected dot is wider
                    .clip(CircleShape) // Make dots circular (or pill-shaped if width != height)
                    .background(
                        // Use blue for selected, light gray for others
                        if (isSelected) OnboardingButtonBlue else Color.LightGray.copy(alpha = 0.5f)
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true) // showSystemUi = true helps visualize with status/nav bars
@Composable
fun OnboardingScreen2Preview() {
    OnboardingScreen2()

}