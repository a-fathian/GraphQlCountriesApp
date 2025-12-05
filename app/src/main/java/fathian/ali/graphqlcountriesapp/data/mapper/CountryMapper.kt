package fathian.ali.graphqlcountriesapp.data.mapper

import com.ali.fathian.CountriesQuery
import com.ali.fathian.CountryQuery
import fathian.ali.graphqlcountriesapp.domain.model.DetailedCountry
import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        capital = capital ?: "No capital",
        emoji = emoji
    )
}

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        name = name,
        emoji = emoji,
        continent = continent.name,
        currency = currency ?: "No currency",
        capital = capital ?: "No capital",
        languages = languages.map { it.name }
    )
}