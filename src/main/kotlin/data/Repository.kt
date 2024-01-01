package data

import data.ApiClient.client
import data.model.MovieResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

class Repository {
    suspend fun popularMovies(): MovieResponse {
        return client.get(
            ApiRoutes.movieRoute()
        ).body<MovieResponse>()

    }
}