package com.cody.plango.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.cody.plango.android.screens.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost


@Composable
fun TripApp(){
    val navHostController = rememberNavController()
    DestinationsNavHost(navGraph = NavGraphs.root, navController = navHostController)
}