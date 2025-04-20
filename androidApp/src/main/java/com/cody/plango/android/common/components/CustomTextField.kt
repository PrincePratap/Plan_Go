package com.cody.plango.android.common.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cody.plango.android.R // Replace with your actual R reference if different

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextField: Boolean = false,
    isSingleLine: Boolean = true,
    @StringRes hint: Int
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    val backgroundColor = Color(0xFFF7F7F9) // soft white like the image

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = stringResource(id = hint)) },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(15.dp)),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (isPasswordTextField && !isPasswordVisible)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        trailingIcon = if (isPasswordTextField) {
            {
//                val icon = if (isPasswordVisible)
//                    Icons.Default.VisibilityOff else Icons.Default.Visibility
//                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
//                    Icon(imageVector = icon, contentDescription = null)
//                }
            }
        } else null,
        singleLine = isSingleLine,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(24.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    var sampleText by remember { mutableStateOf("") }

    MaterialTheme {
            CustomTextField(
                value = sampleText,
                onValueChange = { sampleText = it },
                hint = android.R.string.untitled,
                isPasswordTextField = true
            )
        }

}
