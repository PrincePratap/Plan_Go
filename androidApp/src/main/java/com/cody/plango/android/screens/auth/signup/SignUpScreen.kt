package com.cody.plango.android.screens.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R
import com.cody.plango.android.common.components.CustomButton
import com.cody.plango.android.common.components.CustomTextField

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign up now",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Please fill the details and create account",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(
            value = uiState.username,
            onValueChange = onUsernameChange,
            hint = R.string.username_hint
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.email,
            onValueChange = onEmailChange,
            hint = R.string.email_hint,
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.password,
            onValueChange = onPasswordChange,
            hint = R.string.password_hint,
            isPasswordTextField = true
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Password must be 8 character",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(
            text = "Create Account",
            onClick = onSignUpClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(text = "Already have an account? ", color = Color.Gray)
            Text(
                text = "Loin",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable(onClick = onNavigateToLogin)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        uiState = SignUpUiState(
            username = "john_doe",
            email = "john@example.com",
            password = "password123"
        ),
        onUsernameChange = {},
        onEmailChange = {},
        onPasswordChange = {},
        onNavigateToLogin = {},
        onNavigateToHome = {},
        onSignUpClick = {}
    )
}

