package fathian.ali.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fathian.ali.graphqlcountriesapp.data.ApolloCountryClient
import fathian.ali.graphqlcountriesapp.domain.CountryClient
import fathian.ali.graphqlcountriesapp.domain.GetCountriesUseCase
import fathian.ali.graphqlcountriesapp.domain.GetCountryUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(client: ApolloClient): CountryClient {
        return ApolloCountryClient(client)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient)
    }

}