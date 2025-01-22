package data

import data.ApiClient.client
import data.model.MovieResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

class Repository {
    suspend fun popularMovies(): MovieResponse? {
        return try {
            client.get(
                ApiRoutes.movieRoute()
            ).body<MovieResponse>()
        } catch (e: Exception) {
            println(e.localizedMessage)
            null
        }
    }
}