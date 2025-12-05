package fathian.ali.graphqlcountriesapp.domain

import fathian.ali.graphqlcountriesapp.domain.model.DetailedCountry
import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

class GetCountryUseCase(
    private val countryClient: CountryClient,
) {
    suspend operator fun invoke(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}