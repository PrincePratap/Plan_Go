package com.cody.plango.android.screens.main

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun Main( navigator: DestinationsNavigator){
    val viewModel: MainViewModel = koinViewModel()

    MainScreen()

}