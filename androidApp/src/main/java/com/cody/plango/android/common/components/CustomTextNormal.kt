package com.cody.plango.android.common.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cody.plango.android.R


@Composable
fun CustomTextNormal(modifier: Modifier = Modifier, textResId: Int) {
    Text(
        text = stringResource( id = textResId), // You need some text here

    )
}