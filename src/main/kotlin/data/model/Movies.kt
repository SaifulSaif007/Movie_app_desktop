package data.model


import kotlinx.serialization.Serializable

@Serializable
data class Movies(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val id: Int,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)
