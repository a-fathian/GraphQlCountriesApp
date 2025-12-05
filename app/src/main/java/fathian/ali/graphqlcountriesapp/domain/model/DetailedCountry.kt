package fathian.ali.graphqlcountriesapp.domain.model

data class DetailedCountry(
    val name: String,
    val emoji: String,
    val continent: String,
    val currency: String,
    val capital: String,
    val languages: List<String>,
)
