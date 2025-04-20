package com.cody.plango.android.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dipumba.ytsocialapp.android.common.theming.White
import com.dipumba.ytsocialapp.android.common.theming.Blue

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue, // Button background color
            contentColor = White   // Text (and icon) color
        )
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MaterialTheme {
        CustomButton(
            text = "Sign Up",
            onClick = { /* Preview click */ },
            modifier = Modifier.padding(16.dp)
        )
    }
}
