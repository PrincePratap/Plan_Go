package com.cody.plango.android.screens.search


import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import com.cody.plango.android.common.components.AppSearchBar
import com.cody.plango.android.common.components.TrackCardItem
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import com.cody.plango.android.R

data class SearchResult(
    val title: String,
    val location: String,
    val imageResId: Int
)

@Composable
fun SearchScreen(
    itemClick: () -> Unit = {},
    likeClick: () -> Unit = {},
    shareClick: () -> Unit = {}
){
    val sampleResults = remember {
        listOf(
            SearchResult("Delhi to Manali", "Ride planned for May 6", R.drawable.rectangle_838),
            SearchResult("Mumbai to Goa", "Recently viewed", R.drawable.rectangle_838),
            SearchResult("Pune to Lonavala", "Weekend plan", R.drawable.rectangle_838)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AppSearchBar()

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(sampleResults) { result ->
                TrackCardItem(
                    imageContent = {
                        Image(
                            painter = painterResource(id = result.imageResId),
                            contentDescription = result.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    },
                    title = result.title,
                    location = result.location,
                    onClick = {
                        println("Clicked on ${result.title}")
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}

