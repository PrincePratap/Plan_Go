package com.cody.plango.android.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.cody.plango.android.R

@Composable
fun  CustomIcon(modifier: Modifier , iconId: Int, contentDescription: String) {
    Image(
        painter = painterResource(iconId), // Replace with your icon
        contentDescription = contentDescription,
        modifier = modifier.wrapContentSize()
    )
}