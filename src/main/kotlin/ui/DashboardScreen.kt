package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@Composable
fun DashboardScreen(
    data: DashboardData = DashboardData()
) {
    val movieData = data.dataState
    val scrollState = rememberLazyGridState()

    Column {
        LazyVerticalGrid(
            state = scrollState,
            columns = GridCells.Adaptive(minSize = 220.dp)
        ) {
            items(
                count = movieData.value.size,
                key = { index ->
                    index
                }
            ) { index ->
                Column(modifier = Modifier.padding(8.dp)) {
                    MovieItem(
                        imageUrl = "https://image.tmdb.org/t/p/" + "w342" + movieData.value[index].poster_path,
                        title = movieData.value[index].title ?: ""
                    )

                }

            }
        }
    }

}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}