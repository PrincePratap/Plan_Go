package com.cody.plango.android.Onboarding

import androidx.compose.ui.graphics.Color

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
import com.cody.plango.android.R


// Define the specific blue and orange colors from the image
val OnboardingButtonBlue = Color(0xFF007AFF) // Approximate blue
val OnboardingTextOrange = Color(0xFFFFA500) // Standard orange, adjust if needed

@Composable
fun OnboardingScreen3() {
    // Use Box to allow overlaying the Skip button and status bar content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Or specific background if needed
            .systemBarsPadding() // Add padding for status and navigation bars
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top section with Image and Skip button overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f) // Image takes ~60% of the height
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_onborading3), // Replace with your image
                    contentDescription = "Onboarding landscape",
                    contentScale = ContentScale.Crop, // Crop to fill the bounds
                    modifier = Modifier.fillMaxSize()
                )


            }

            // Bottom White Content Section
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Takes remaining space
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = MaterialTheme.colorScheme.surface // White background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 24.dp), // Padding inside the white area
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title Text with highlighted "people"
                    Text(
                        text = buildAnnotatedString {
                            append("People don't take trips,\ntrips take ")
                            withStyle(style = SpanStyle(
                                color = OnboardingTextOrange,
                                fontWeight = FontWeight.Bold)
                            ) {
                                append("people")
                            }
                            // You might need another drawable/canvas for the underline effect
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp, // Adjust line height for spacing
                        color = MaterialTheme.colorScheme.onSurface // Default text color
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Subtitle Text
                    Text(
                        text = "To get the best of your adventure you just need to leave and go where you like. we are waiting for you",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Gray // Muted color for subtitle
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Pager Indicator
                    PagerIndicator(currentPage = 2, pageCount = 3) // Example: 3rd page active

                    Spacer(modifier = Modifier.weight(1f)) // Push button to bottom

                    // Next Button
                    Button(
                        onClick = { /* Handle Next */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp), // Rounded button corners
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OnboardingButtonBlue // Custom blue color
                        )
                    ) {
                        Text("Next", fontSize = 16.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(16.dp)) // Space before bottom edge/nav bar area
                }
            }
        }


    }
}

@Composable
fun PagerIndicator(currentPage: Int, pageCount: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between dots
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage
            Box(
                modifier = Modifier
                    .size(width = if (isSelected) 20.dp else 8.dp, height = 8.dp) // Wider selected dot
                    .clip(CircleShape)
                    .background(
                        if (isSelected) OnboardingButtonBlue else Color.LightGray // Colors for selected/unselected
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true) // showSystemUi to see status/nav bars
@Composable
fun OnboardingScreen3Preview() {
    OnboardingScreen3()
}