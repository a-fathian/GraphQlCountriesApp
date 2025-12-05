package fathian.ali.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fathian.ali.graphqlcountriesapp.domain.GetCountriesUseCase
import fathian.ali.graphqlcountriesapp.domain.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CountryState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update {
                it.copy(
                    countries = getCountriesUseCase(), isLoading = false
                )
            }

        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update { it.copy(selectedCountry = getCountryUseCase(code)) }
        }
    }

    fun dismissCountryDialog() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = null
                )
            }
        }
    }

}