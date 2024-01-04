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

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.startOffsetForPage(page: Int): Float {
    return offsetForPage(page).coerceAtLeast(0f)
}

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.endOffsetForPage(page: Int): Float {
    return offsetForPage(page).coerceAtMost(0f)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(
    data: DashboardData = DashboardData()
) {
    val movieData = data.dataState
    val scrollState = rememberLazyGridState()

    val pagerState = rememberPagerState(0)

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (movieData.value.size)
            )

        }
    }

    Column {
        HorizontalPager(pageCount = movieData.value.size, state = pagerState) { page: Int ->
            PagerContent(
                imageUrl = "https://image.tmdb.org/t/p/" + "w780" + movieData.value[page].poster_path,
            )
        }

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