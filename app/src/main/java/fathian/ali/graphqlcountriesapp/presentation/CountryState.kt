package fathian.ali.graphqlcountriesapp.presentation

import fathian.ali.graphqlcountriesapp.domain.model.DetailedCountry
import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

data class CountryState(
    val isLoading: Boolean = false,
    val countries: List<SimpleCountry> = emptyList(),
    val selectedCountry: DetailedCountry? = null,
)
