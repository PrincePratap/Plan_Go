package com.cody.plango.android.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cody.plango.android.common.components.MyCustomBottomNavigationBarSvg
import androidx.compose.runtime.Composable
import com.cody.plango.android.R
import com.cody.plango.android.screens.user.UserProfileScreen

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("profile") }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            when (currentScreen) {
//                "home" -> HomeScreen()
//                "calendar" -> CalendarScreen()
//                "search" -> SearchScreen()
//                "messages" -> MessagesScreen()
                "profile" -> UserProfileScreen(  name = "Aditya Singh",
                    email = "aditya@example.com",
                    imageResId = R.drawable.profile_avatar)
            }
        }

        Spacer(modifier = Modifier.height(8.dp)) // Optional spacing

        MyCustomBottomNavigationBarSvg(
            modifier = Modifier.fillMaxWidth(),
            navigateHomeScreen = { currentScreen = "home" },
            navigateCalendarScreen = { currentScreen = "calendar" },
            navigateSearchScreen = { currentScreen = "search" },
            navigateMessagesScreen = { currentScreen = "messages" },
            navigateProfileScreen = { currentScreen = "profile" }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
