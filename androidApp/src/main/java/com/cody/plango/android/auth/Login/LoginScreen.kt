package com.cody.plango.android.auth.Login



import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    onSignInClick: () -> Unit,
    onNavigateToSignup: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("*********") } // Pre-filled for preview like image
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background // Use theme background color
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding from Scaffold
                .padding(horizontal = 24.dp), // Add horizontal padding for content
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Top Bar Section (Back Button)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp) // Adjust padding as needed
            ) {
                IconButton(
                    onClick = { /* Handle back navigation */ },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(40.dp) // Adjust size
                        .clip(CircleShape) // Make it circular
                        .background(MaterialTheme.colorScheme.surfaceVariant) // Light grey background
                ) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                        contentDescription = "Back",
//                        tint = MaterialTheme.colorScheme.onSurfaceVariant // Adjust tint if needed
//                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp)) // Space between back button area and title

            // Title
            Text(
                text = "Sign in now",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Please sign in to continue our app",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray, // Subdued color
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp)) // Space before input fields

            // Email Input Field (Looks like filled style)
            TextField(
                value = email,
                onValueChange = { email = it },
                // placeholder = { Text("Email or username") }, // Optional: Add placeholder
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp), // Rounded corners
                colors = TextFieldDefaults.colors( // Customize colors for filled look
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedIndicatorColor = Color.Transparent, // Hide indicator line
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input Field (Looks like filled style)
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp), // Rounded corners
                colors = TextFieldDefaults.colors( // Customize colors for filled look
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedIndicatorColor = Color.Transparent, // Hide indicator line
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                trailingIcon = {
//                    val image = if (passwordVisible)
//                        Icons.Filled.Visibility
//                    else Icons.Filled.VisibilityOff
//                    // Provide a description for accessibility
//                    val description = if (passwordVisible) "Hide password" else "Show password"
//
//                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                        Icon(imageVector = image, description, tint = MaterialTheme.colorScheme.onSurfaceVariant)
//                    }
//                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Forget Password Link
            Text(
                text = "Forget Password?",
                color = MaterialTheme.colorScheme.primary, // Use primary color for link
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.End) // Align to the right
                    .clickable { /* Handle Forgot Password */ }
            )

            Spacer(modifier = Modifier.height(32.dp)) // Space before Sign In button

            // Sign In Button
            Button(
                onClick = { /* Handle Sign In */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), // Standard button height
                shape = RoundedCornerShape(12.dp), // Rounded corners for button
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Blue button
                    contentColor = MaterialTheme.colorScheme.onPrimary // White text
                )
            ) {
                Text("Sign In", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(24.dp)) // Space before Sign Up prompt

            // Sign Up Prompt
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Sign up",
                    color = MaterialTheme.colorScheme.primary, // Blue link color
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    modifier = Modifier.clickable { /* Handle Sign Up navigation */ }
                )
            }
            Spacer(modifier = Modifier.weight(1f)) // Push content up if screen is tall

        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode Preview")
@Composable
fun LoginScreenPreview() {
    // Wrap the screen in the defined theme for preview
//        LoginScreen()

}