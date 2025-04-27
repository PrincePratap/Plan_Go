package com.cody.plango.android.screens.auth.ForgotPassword


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cody.plango.android.R
import com.cody.plango.android.common.components.CustomButton
import com.cody.plango.android.common.components.CustomTextField

// Assuming you have a basic Material 3 theme set up
// Replace 'MyApplicationTheme' with your actual theme name if different


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onEmailChange: (String) -> Unit,
    onNavigateBack: () -> Unit = {},
    onClickOnReset: () -> Unit = {}
) {

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


            CustomTextField(
                modifier = modifier,
                "",
                onEmailChange,
                hint = R.string.email_hint,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(32.dp)) // Space before button

            CustomButton(modifier = modifier, text = "Reset password", onClick = onClickOnReset)

            Spacer(modifier = Modifier.weight(1f)) // Pushes content up if needed, though spacing might be enough
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812) // Simulates iPhone X/XS/11 Pro size
@Composable
fun ForgotPasswordScreenPreview() {
    // Use a basic MaterialTheme for the preview if you don't have one set up globally
    MaterialTheme {
        ForgotPasswordScreen(modifier = Modifier, onEmailChange = {})
    }
}

