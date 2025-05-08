package com.cody.plango.android.screens.search

import androidx.compose.runtime.Composable
import com.cody.plango.android.screens.auth.Login.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel


@Destination
@Composable
fun Search(
    navigator: DestinationsNavigator
) {
    val viewModel: SearchViewModel = koinViewModel()

    SearchScreen()

}