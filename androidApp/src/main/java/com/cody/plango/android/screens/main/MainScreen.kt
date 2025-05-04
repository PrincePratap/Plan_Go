package com.cody.plango.android.screens.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cody.plango.android.common.components.MyCustomBottomNavigationBarSvg

@Composable
fun MainScreen() {
    MyCustomBottomNavigationBarSvg(
        modifier = Modifier.fillMaxWidth(),
        navigateHomeScreen = {},
        navigateCalendarScreen = {},
        navigateSearchScreen = {},
        navigateMessagesScreen  = {},
        navigateProfileScreen = {}

    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
