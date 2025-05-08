package com.cody.plango.android.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// iOS-like system colors for closer resemblance
val iOSSystemGrayPlaceHolder = Color(0xFF8E8E93) // Placeholder text and icon tint
val iOSSystemGray6Background = Color(0xFFF0F0F0) // Search bar background
val iOSSeparatorLineColor = Color(0xFFDCDCDC) // Very light gray for the divider

@Composable
fun AppSearchBar() {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .width(335.dp) // Specific width from the image
            .height(48.dp) // Specific height from the image
            .background(
                color = iOSSystemGray6Background,
                shape = RoundedCornerShape(10.dp) // Rounded corners
            ),
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary), // Standard cursor color
        textStyle = TextStyle(
            color = Color.Black, // Text color when typing
            fontSize = 17.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp), // Internal padding for all content
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = iOSSystemGrayPlaceHolder,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Space between search icon and text input

                Box(
                    modifier = Modifier.weight(1f), // Text input takes available space
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            "Search Places",
                            color = iOSSystemGrayPlaceHolder,
                            fontSize = 17.sp
                        )
                    }
                    innerTextField() // The actual text input field
                }

                Spacer(modifier = Modifier.width(8.dp)) // Space before the divider and mic icon

                // Vertical Divider
                Box(
                    modifier = Modifier
                        .height(24.dp) // Slightly shorter than icon's visual bounds
                        .width(1.dp)
                        .background(color = iOSSeparatorLineColor)
                )

                Spacer(modifier = Modifier.width(8.dp)) // Space between divider and mic icon

//                Icon(
//                    imageVector = Icons.Filled.Mic,
//                    contentDescription = "Microphone Icon",
//                    tint = iOSSystemGrayPlaceHolder,
//                    modifier = Modifier.size(22.dp)
//                )
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF2C2C2E) // Dark background like in the image
@Composable
fun AppSearchBarPreview() {
    MaterialTheme { // MaterialTheme is needed for MaterialTheme.colorScheme.primary (cursor)
        Box(
            modifier = Modifier
                .fillMaxWidth() // Take full preview width
                .padding(16.dp) // Add some padding around the search bar
                .background(Color(0xFF2C2C2E)), // Match preview's requested background
            contentAlignment = Alignment.Center // Center the search bar within the Box
        ) {
            AppSearchBar()
        }
    }
}