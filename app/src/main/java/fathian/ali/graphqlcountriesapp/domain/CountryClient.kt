package fathian.ali.graphqlcountriesapp.domain

import fathian.ali.graphqlcountriesapp.domain.model.DetailedCountry
import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}