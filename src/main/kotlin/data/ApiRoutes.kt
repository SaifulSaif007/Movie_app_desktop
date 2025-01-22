package data

object ApiRoutes {
    private const val BASE_URL = "https://api.themoviedb.org/3"
    private const val ACCESS_TOKEN = "697bf3a9a65fafc6982838746d30694b"

    fun movieRoute(): String {
        return "$BASE_URL/movie/popular?api_key=${ACCESS_TOKEN}&page=2"
    }
}