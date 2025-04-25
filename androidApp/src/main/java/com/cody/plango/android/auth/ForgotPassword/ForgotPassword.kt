package com.cody.plango.android.auth.ForgotPassword


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Assuming you have a basic Material 3 theme set up
// Replace 'MyApplicationTheme' with your actual theme name if different



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(onNavigateBack: () -> Unit = {}) {
    var email by remember { mutableStateOf("www.uihut@gmail.com") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background // Ensure scaffold background is white
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding from Scaffold
                .padding(horizontal = 24.dp), // Add horizontal padding for content
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Space from top bar

            Text(
                text = "Forgot password",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground // Black or dark text
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Enter your email account to reset\nyour password",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray // Muted text color
            )

            Spacer(modifier = Modifier.height(48.dp)) // More space before input

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text("Email Address") },
                shape = RoundedCornerShape(12.dp), // Rounded corners for the field
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F7), // Light gray background
                    unfocusedContainerColor = Color(0xFFF7F7F7),
                    disabledContainerColor = Color(0xFFF7F7F7),
                    focusedIndicatorColor = Color.Transparent, // Hide indicator line
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(modifier = Modifier.height(32.dp)) // Space before button

            Button(
                onClick = { /* TODO: Handle password reset logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), // Standard button height
                shape = RoundedCornerShape(12.dp), // Rounded corners for the button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007AFF) // Specific blue color from image
                )
            ) {
                Text(
                    text = "Reset Password",
                    fontSize = 16.sp,
                    color = Color.White // White text on button
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Pushes content up if needed, though spacing might be enough
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812) // Simulates iPhone X/XS/11 Pro size
@Composable
fun ForgotPasswordScreenPreview() {
    // Use a basic MaterialTheme for the preview if you don't have one set up globally
    MaterialTheme {
        ForgotPasswordScreen()
    }
}

// You might need a basic Theme definition if you don't have one
// Example Minimal Theme (replace with your actual theme):
/*
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme( // Define dark colors if needed
            primary = Color(0xFF007AFF),
            background = Color.Black,
            onBackground = Color.White,
            surface = Color.DarkGray,
            onSurface = Color.White
            // ... other colors
        )
    } else {
        lightColorScheme( // Define light colors matching the image
            primary = Color(0xFF007AFF), // Blue
            background = Color.White,
            onBackground = Color.Black,
            surface = Color.White,
            onSurface = Color.Black,
            // Define other colors as needed, e.g., secondary, error, etc.
            // Ensure container colors for text fields etc. can be derived or set explicitly
             outline = Color.LightGray // Might be used by text fields if not overridden
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(), // Define your typography if needed
        content = content
    )
}
*/

// Define Typography if needed, e.g.,
// val Typography = Typography(...)