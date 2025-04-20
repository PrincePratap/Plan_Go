package com.cody.plango.android.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.R // Replace with your actual drawable if different

@Composable
fun EventCard() {
    Card(
        modifier = Modifier
            .width(335.dp)
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Image
            Image(
                painter = painterResource(id = R.drawable.rectangle_838), // Replace with your drawable
                contentDescription = "Event Location Image",
                modifier = Modifier
                    .size(76.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Middle Text Column
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                InfoRow(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    text = "26 January 2022"
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "High Rech Park",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(6.dp))

                InfoRow(
                    painter = painterResource(id = R.drawable.ic_location),
                    text = "Zeero Point, Sylhet"
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow), // replace with your actual drawable name
                contentDescription = "Arrow",
                tint = Color.Unspecified, // Keep original colors in the image
                modifier = Modifier.size(18.dp)
            )

        }
    }
}

@Composable
fun InfoRow(painter: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            fontSize = 13.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2C2C2C)
@Composable
fun EventCardPreview() {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            EventCard()
        }

}
