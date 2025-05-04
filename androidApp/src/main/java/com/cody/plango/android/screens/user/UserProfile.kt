package com.cody.plango.android.screens.user

import androidx.compose.runtime.Composable
import com.cody.plango.android.screens.auth.signup.SignUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun UserProfile(
    navigator: DestinationsNavigator
) {
    val viewModel: UserProfileViewModel = koinViewModel()

//    UserProfileScreen()


}