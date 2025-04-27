import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cody.plango.android.fake_data.FacilityItem

@Composable
fun FacilityItem(
    facility: FacilityItem, // Pass in a facility item
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(width = 70.dp, height = 70.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF3F4F6))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = facility.iconId),
            contentDescription = facility.label,
            modifier = Modifier.size(28.dp),
            // Optional tint
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = facility.label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 10.sp
        )
    }



}

@Preview(showBackground = true)
@Composable
fun FacilityItemPreview() {
//    FacilityItem(
//        facility = FacilityItem(
//            iconId = R.drawable.ic_wifi, // Make sure this icon exists in res/drawable
//            label = "Wi-Fi"
//        )
//    )
}