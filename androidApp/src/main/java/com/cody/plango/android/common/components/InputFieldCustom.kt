package com.cody.plango.android.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cody.plango.android.common.components.theming.VeryLightBlue


@Composable
fun InputFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderText, color = Color.Gray) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = VeryLightBlue,
            focusedContainerColor = Color(0xFFF3F4F6),
            unfocusedContainerColor = Color.White
        ),
        singleLine = isSingleLine
    )
}
@Preview(showBackground = true)
@Composable
fun InputFieldCustomPreview() {
    InputFieldCustom(
        value = "",
        onValueChange = {},
        placeholderText = "Enter text here"
    )
}