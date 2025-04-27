package com.cody.plango.android.screens.auth.ForgotPassword

import androidx.compose.runtime.Composable
import com.cody.plango.android.screens.auth.Login.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Composable
//@Destination(start = true)
fun  ForgotPassword(navigator: DestinationsNavigator) {
    val viewModel: ForgotPasswordViewModel = koinViewModel()
    ForgotPasswordScreen(onEmailChange = {}, onClickOnReset = {})

}