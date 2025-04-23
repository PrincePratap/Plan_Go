package com.cody.plango.android.common.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes // Import needed for resource IDs
import androidx.compose.foundation.Image // Import Image composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
// Removed unused material icons import if applicable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter // Import for tinting drawables
import androidx.compose.ui.res.painterResource // Import painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cody.plango.android.R

// Assume R class is generated correctly for your drawables
// If your package name is different, the R import might change implicitly.
// If you have issues, explicitly import your app's R class:
// import com.example.settingscard.R



// Data class now holds a Drawable Resource ID
data class MenuItem(
    @DrawableRes val iconResId: Int, // Use drawable resource Int ID
    val text: String,
    val contentDescription: String
)

//@Composable
//fun SettingsCard() {
//    // --- IMPORTANT ---
//    // Replace these with your ACTUAL drawable resource IDs from your R class
//    // Example: If your profile icon is named ic_profile.xml in res/drawable,
//    // use R.drawable.ic_profile
//    val menuItems = listOf(
//        MenuItem(R.drawable.ic_profile, "Profile", "Profile Settings"),
//        MenuItem(R.drawable.ic_bookmark, "Bookmarked", "View Bookmarked Items"),
//        MenuItem(R.drawable.ic_previous_trips, "Previous Trips", "View Previous Trips"),
//        MenuItem(R.drawable.ic_settings, "Settings", "App Settings"),
//        MenuItem(R.drawable.ic_version, "Version", "App Version Info")
//    )
//
//    Card(
//        modifier = Modifier
//            .widthIn(max = 400.dp),
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(vertical = 8.dp)
//        ) {
//            menuItems.forEachIndexed { index, item ->
//                SettingsMenuItem(
//                    iconResId = item.iconResId, // Pass the resource ID
//                    text = item.text,
//                    contentDescription = item.contentDescription,
//                    onClick = { /* Handle click for item.text */ }
//                )
//                if (index < menuItems.lastIndex) {
//                    HorizontalDivider(
//                        modifier = Modifier.padding(start = 56.dp), // Adjust indent as needed based on icon size/padding
//                        thickness = 1.dp,
//                        color = Color.Gray.copy(alpha = 0.2f)
//                    )
//                }
//            }
//        }
//    }
//}

//@Composable
//fun SettingsMenuItem(
//    @DrawableRes iconResId: Int, // Parameter is now a drawable resource ID
//    text: String,
//    contentDescription: String,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .clickable(onClick = onClick)
//            .padding(horizontal = 16.dp, vertical = 14.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // Use Image composable with painterResource
//        Image(
//            painter = painterResource(id = iconResId),
//            contentDescription = contentDescription,
//            // Apply tint using ColorFilter if your drawables are single-color vectors
//            colorFilter = ColorFilter.tint(Color.Gray),
//            modifier = Modifier.size(24.dp) // Explicitly set size for consistency
//        )
//        Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text
//        Text(
//            text = text,
//            style = MaterialTheme.typography.bodyLarge,
//            color = Color.Black.copy(alpha = 0.85f),
//            modifier = Modifier.weight(1f)
//        )
//        Icon( // Keep using Icon for the standard Material arrow
//            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//            contentDescription = "Go to $text",
//            tint = Color.Gray
//        )
//    }
//}

@Preview(showBackground = true, backgroundColor = 0xFF212121)
@Composable
fun SettingsCardPreview() {


//        SettingsCard() // This will now use the R.drawable references
}