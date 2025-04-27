package com.cody.plango.android.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.annotation.DrawableRes // Import DrawableRes
import androidx.compose.ui.res.painterResource // Import painterResource
import com.cody.plango.android.R


// Data class to represent each navigation item using Drawable IDs
data class BottomNavItemSvg(
    val label: String,
    @DrawableRes val iconResId: Int,
    @DrawableRes val selectedIconResId: Int? = null // Optional: Use different icon when selected
)


@Composable
fun MyCustomBottomNavigationBarSvg(modifier: Modifier) {
    var selectedItemLabel by remember { mutableStateOf("Calendar") }

    // Define the navigation items using Drawable Resource IDs
    // Replace these R.drawable references with your actual file names
    val items = listOf(
        BottomNavItemSvg("Home", R.drawable.ic_home_outline),
        BottomNavItemSvg("Calendar", R.drawable.ic_calendar_outline, R.drawable.ic_calendar_filled), // Use Filled ID when selected
        BottomNavItemSvg("Search", R.drawable.ic_search), // Special case handled separately
        BottomNavItemSvg("Messages", R.drawable.ic_chat_outline), // Example icon ID
        BottomNavItemSvg("Profile", R.drawable.ic_person_outline)
    )

    // Colors remain the same
    val selectedColor = Color(0xFF007AFF) // Blue color
    val unselectedColor = Color.Gray
    val fabBackgroundColor = selectedColor
    val fabContentColor = Color.White
    val barBackgroundColor = Color.White

    Surface(
        color = barBackgroundColor,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        shadowElevation = 8.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.navigationBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items.forEach { item ->
                    val isSelected = selectedItemLabel == item.label

                    if (item.label == "Search") {
                        // Special handling for the central FAB
                        FloatingActionButton(
                            onClick = {
                                selectedItemLabel = item.label
                                println("${item.label} clicked") // Example action
                            },
                            shape = CircleShape,
                            containerColor = fabBackgroundColor,
                            contentColor = fabContentColor, // contentColor is used for Icon tint by default
                            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
                            modifier = Modifier
                                .size(56.dp)
                                .offset(y = (-10).dp) // Optional offset
                        ) {
                            Icon(
                                // Use painterResource for the FAB icon
                                painter = painterResource(id = item.iconResId),
                                contentDescription = item.label
                                // Tint is handled by FAB's contentColor
                            )
                        }
                    } else {
                        // Regular navigation items
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable {
                                    selectedItemLabel = item.label
                                    println("${item.label} clicked") // Example action
                                }
                                .padding(vertical = 8.dp)
                        ) {
                            // Determine which drawable resource ID to use
                            val iconId = if (isSelected && item.selectedIconResId != null) {
                                item.selectedIconResId
                            } else {
                                item.iconResId
                            }

                            Icon(
                                // Use painterResource for regular items
                                painter = painterResource(id = iconId),
                                contentDescription = item.label,
                                tint = if (isSelected) selectedColor else unselectedColor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = item.label,
                                color = if (isSelected) selectedColor else unselectedColor,
                                fontSize = 12.sp,
                                maxLines = 1
                            )
                        }
                    }
                }
            }

            // Home Indicator (Optional)
            Box(
                modifier = Modifier
                    .width(134.dp)
                    .height(5.dp)
                    .background(Color.Black, shape = CircleShape)
                    .padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

// IMPORTANT: Make sure you have placeholder drawables with these exact names
// in your `res/drawable` folder for the preview to work correctly,
// or the preview might crash or show errors.
// You can create simple vector drawables as placeholders if needed.
@Preview(showBackground = true, backgroundColor = 0xFF2C2C2C)
@Composable
fun MyCustomBottomNavigationBarSvgPreview() {
    // Create dummy drawable resources for preview if they don't exist
    // This part is just for making the @Preview work without real drawables
    val dummyIcon = android.R.drawable.ic_menu_gallery // Or any built-in placeholder


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2C2C2C)),
            contentAlignment = Alignment.BottomCenter
        ) {
            // You might need to slightly adapt the main composable or pass
            // the dummy items to it for a flawless preview if it relies
            // heavily on specific resource IDs that might not exist during preview generation.
            // However, often just having *any* drawable works for preview layout.
            MyCustomBottomNavigationBarSvg(modifier = Modifier) // Usually works if R.drawable resolves somehow
        }

}

