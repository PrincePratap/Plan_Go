package com.cody.plango.android.common.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R

// Assuming you have a placeholder image in your drawable resources named 'placeholder_house.xml' or similar
// For this example, I'll create a simple placeholder Composable.
// If you have an actual image, replace R.drawable.placeholder_house with your resource ID.

@Composable
fun PlaceholderImage(modifier: Modifier = Modifier) {
    // In a real app, you'd use painterResource(id = R.drawable.your_image)
    // For this preview, we'll use a colored box as a placeholder.
    // The image in the example has specific content, which we'll abstract with a color.
    Box(
        modifier = modifier
            .background(Color(0xFFB0BEC5)) // A neutral placeholder color
    ) {
        // If you have a generic drawable to represent an illustration:
        // Image(
        //     painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with a real placeholder
        //     contentDescription = "Property image placeholder",
        //     contentScale = ContentScale.Crop,
        //     modifier = Modifier.fillMaxSize()
        // )
    }
}


@Composable
fun TrackCardItem(
    imageContent: @Composable () -> Unit = { PlaceholderImage(Modifier.fillMaxSize()) },
    title: String = "Casa Las Tirtugas",
    location: String = "Av Damero, Mexico",
    onClick: () -> Unit = {} // ✅ Add this line

) {
    Card(
        modifier = Modifier
            .width(161.dp)
            .height(194.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp), // Rounded corners for the card
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Explicitly white background
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Slight shadow
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp) // Approximate height for the image part
            ) {
                // Image
                Box(modifier = Modifier
                    .fillMaxSize()
                    // Clip the image content to have rounded top corners matching the card.
                    // Card itself clips its content, but this ensures the image content fits perfectly.
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                ) {
                    imageContent()
                }


                // Favorite Icon with semi-transparent background
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp) // Padding from the top-right corner of the image
                        .size(30.dp) // Size of the circular background
                        .background(
                            color = Color(0x99FFFFFF), // Semi-transparent white (alpha ~60%)
                            // The example shows a very light pinkish transparent circle.
                            // Color(0x60FFEBEE) could be another option (semi-transparent light pink)
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = Color(0xFFF06292), // A medium pink/red color for the heart
                        modifier = Modifier.size(18.dp) // Size of the heart icon itself
                    )
                }
            }

            // Text Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp), // Padding for text area
                verticalArrangement = Arrangement.spacedBy(4.dp) // Space between title and location
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1 // Ensure title is single line
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp) // Space between icon and text
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location Pin",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp) // Slightly smaller location icon
                    )
                    Text(
                        text = location,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        maxLines = 1 // Ensure location is single line
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1F1F1F) // Dark background similar to example
@Composable
fun PropertyCardItemPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize() // Fill preview area
                .background(Color(0xFF1F1F1F)) // Match preview background color
                .padding(16.dp), // Add some padding around the card for better viewing
            contentAlignment = Alignment.Center // Center the card in the preview
        ) {
            // For the preview, we can use the PlaceholderImage directly
            // or a more illustrative one if available.
            // If you have an actual image like R.drawable.casa_las_tirtugas_image:
             val casaImage = @Composable {
                 Image(
                     painter = painterResource(id = R.drawable.rectangle_838),
                     contentDescription = "Casa Las Tirtugas",
                     contentScale = ContentScale.Crop,
                     modifier = Modifier.fillMaxSize()
                 )
             }
            TrackCardItem(
                imageContent = {
                    // Using a colored Box as a placeholder for the actual house image
                    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFADCBE3)))
                }
            )
        }
    }
}