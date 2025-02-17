package ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import data.Repository
import data.model.Movies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardData {

    val dataState: MutableState<List<Movies>> = mutableStateOf(emptyList())

    init {
        loadPopularMovie()
    }

    private fun loadPopularMovie() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = Repository().popularMovies()
            println(response)

            response?.results?.let {
                dataState.value = it
            }
        }
    }
}