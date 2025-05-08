package com.cody.plango.android.screens.auth.signup

import androidx.compose.runtime.Composable


import com.cody.plango.android.screens.destinations.LoginDestination
import com.cody.plango.android.screens.destinations.SignUpDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel


@Destination
@Composable
fun SignUp(
    navigator: DestinationsNavigator
) {
    val viewModel: SignUpViewModel = koinViewModel()
    SignUpScreen(
        uiState = viewModel.uiState,
        onUsernameChange = viewModel::updateUsername,
        onFullNameChange = viewModel::updateFullName,
        onEmailChange = viewModel::updateEmail,
        onPhoneNumberChange = viewModel::updatePhoneNumber,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {
            navigator.navigate(LoginDestination){
                popUpTo(SignUpDestination.route){
                    inclusive = true
                }
            }
        },
        onNavigateToHome = {
//            navigator.navigate(HomeDestination){
//                popUpTo(SignUpDestination.route){inclusive = true}
//            }
        },
        onSignUpClick = viewModel::signUp,
    )
}