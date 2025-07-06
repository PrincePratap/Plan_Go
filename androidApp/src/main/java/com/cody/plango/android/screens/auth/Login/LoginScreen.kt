package com.cody.plango.android.screens.auth.Login



import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.common.components.InputFieldCustom
import com.cody.plango.android.common.components.theming.OceanBlue


@Composable
fun LoginScreen(
    clickOnContinue: () -> Unit = {},
    clickOnForgetPassword: () -> Unit = {},
    navigateToSignUp: () -> Unit = {}
) {
    var phoneOrEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

//                Text(
//                    text = "Create an account to continue",
//                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
//                )

                Spacer(modifier = Modifier.height(48.dp))

                Spacer(modifier = Modifier.height(16.dp))


                // Phone number input field
                InputFieldCustom(
                    value = phoneOrEmail,
                    onValueChange = { phoneOrEmail = it },
                    placeholderText = "Enter phone number or email"
                )
                Spacer(modifier = Modifier.height(16.dp))
                InputFieldCustom(
                    value = password,
                    onValueChange = { password = it },
                    placeholderText = "Enter password"
                )
                TextButton(
                    onClick = {
                        clickOnForgetPassword()
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Forgot password?",
                        color = Color(0xFF6A67E9),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }



                Spacer(modifier = Modifier.height(16.dp))



                Spacer(modifier = Modifier.height(16.dp))

// Continue Button
                Button(
                    onClick = { clickOnContinue() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OceanBlue)
                ) {
                    Text(
                        "Continue",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

//                SignUpPrompt(Color.Black, navigate = {navigateToSignUp() })


            }

            Spacer(modifier = Modifier.weight(1f))

//            LegalText()

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(clickOnContinue = {})
    }
}
