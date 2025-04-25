package com.cody.plango.android.auth.OtpVerification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpVerificationScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background // Use theme background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp) // Add horizontal padding
        ) {
            // Top section with Back Arrow
            Spacer(modifier = Modifier.height(40.dp)) // Simulate status bar space + padding
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    onClick = { /* Handle back press */ },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                        contentDescription = "Back",
//                        tint = MaterialTheme.colorScheme.onSurface // Use theme color
//                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Space after back arrow row

            // Title
            Text(
                text = "OTP Verification",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface // Use theme color
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle / Instructions
            Text(
                text = "Please check your email www.uihut@gmail.com to see the verification code",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant // Slightly muted color
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(48.dp)) // More space before OTP section

            // OTP Code Label
            Text(
                text = "OTP Code",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface // Use theme color
                ),
                modifier = Modifier.align(Alignment.Start) // Align to the start
            )

            Spacer(modifier = Modifier.height(16.dp))

            // OTP Input Boxes Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Distribute boxes evenly
            ) {
                OtpDigitBox("8")
                OtpDigitBox("6")
                OtpDigitBox("9")
                OtpDigitBox("5")
            }

            Spacer(modifier = Modifier.height(48.dp)) // More space before Verify button

            // Verify Button
            Button(
                onClick = { /* Handle verification */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), // Standard button height
                shape = RoundedCornerShape(12.dp), // Rounded corners
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007AFF) // Specific blue color from image
                )
            ) {
                Text(
                    text = "Verify",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        color = Color.White // White text on button
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Resend Code Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween, // Space between text and timer
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Resend code to",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant // Muted color
                    )
                )
                Text(
                    text = "01:26",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Muted color
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Push content up if screen is tall
        }
    }
}

@Composable
fun OtpDigitBox(digit: String) {
    Box(
        modifier = Modifier
            .size(64.dp) // Adjust size as needed
            .clip(RoundedCornerShape(12.dp)) // Rounded corners
            .background(MaterialTheme.colorScheme.surfaceVariant), // Light gray background from theme
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = digit,
            style = MaterialTheme.typography.headlineSmall.copy( // Larger text for digits
                fontWeight = FontWeight.Medium, // Not too bold
                color = MaterialTheme.colorScheme.onSurfaceVariant // Color for text inside box
            ),
            fontSize = 24.sp // Explicit font size if needed
        )
    }
}

// Define a simple Theme if you don't have one
@Composable
fun OtpVerificationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme( // Using light theme colors as base
            primary = Color(0xFF007AFF),
            onPrimary = Color.White,
            background = Color.White,
            surface = Color.White,
            onBackground = Color.Black,
            onSurface = Color.Black,
            surfaceVariant = Color(0xFFF2F2F7), // Light gray for boxes
            onSurfaceVariant = Color(0xFF8A8A8E) // Gray for subtle text
            // You can customize other colors as needed
        ),
        typography = Typography(), // Use default or your custom Typography
        content = content
    )
}


@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun OtpVerificationScreenPreview() {
    OtpVerificationTheme { // Wrap preview in the theme
        OtpVerificationScreen()
    }
}