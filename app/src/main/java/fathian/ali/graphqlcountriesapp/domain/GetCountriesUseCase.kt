package fathian.ali.graphqlcountriesapp.domain

import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient,
) {
    suspend operator fun invoke(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}