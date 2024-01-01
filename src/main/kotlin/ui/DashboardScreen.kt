package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.ApiClient
import data.Repository
import util.loadNetworkImage
import java.lang.Exception

@Composable
fun DashboardScreen() {
    val scrollState = rememberLazyGridState()

    LaunchedEffect(Unit) {
        try {
            val response = Repository().popularMovies()
            println("screen$response")
        } catch (e: Exception) {
            println(e.localizedMessage)
        }
    }

    LazyVerticalGrid(
        state = scrollState,
        columns = GridCells.Adaptive(minSize = 220.dp)
    ) {
        items(
            count = 10,
            key = { index ->
                index
            }
        ) { index ->
            Column(modifier = Modifier.padding(8.dp)) {

                MovieItem(
                    imageUrl = "https://images.unsplash.com/photo-1703555508141-4397207fc6d2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3wxNzQ1NDV8MHwxfGFsbHw0fHx8fHx8Mnx8MTcwMzk1MzUyMXw&ixlib=rb-4.0.3&q=80&w=1080",
                )

            }

        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}