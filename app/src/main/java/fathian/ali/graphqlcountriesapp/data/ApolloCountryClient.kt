package fathian.ali.graphqlcountriesapp.data

import com.ali.fathian.CountriesQuery
import com.ali.fathian.CountryQuery
import com.apollographql.apollo3.ApolloClient
import fathian.ali.graphqlcountriesapp.data.mapper.toDetailedCountry
import fathian.ali.graphqlcountriesapp.data.mapper.toSimpleCountry
import fathian.ali.graphqlcountriesapp.domain.CountryClient
import fathian.ali.graphqlcountriesapp.domain.model.DetailedCountry
import fathian.ali.graphqlcountriesapp.domain.model.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}