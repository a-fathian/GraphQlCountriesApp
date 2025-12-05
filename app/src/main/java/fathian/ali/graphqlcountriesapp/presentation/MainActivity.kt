package fathian.ali.graphqlcountriesapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import fathian.ali.graphqlcountriesapp.presentation.ui.theme.GraphQlCountriesAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraphQlCountriesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = viewModel<CountriesViewModel>()
                    val state = viewModel.state.collectAsState()
                    CountriesScreen(
                        state = state.value,
                        onSelectCountry = viewModel::selectCountry,
                        onDismissCountryDialog = viewModel::dismissCountryDialog
                    )
                }
            }
        }
    }
}