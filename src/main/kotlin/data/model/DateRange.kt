package data.model

import kotlinx.serialization.Serializable

@Serializable
data class DateRange(
    val maximum: String,
    val minimum: String
)
