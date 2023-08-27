package com.gkreduction.movieapp.ui

import androidx.lifecycle.viewModelScope
import com.gkreduction.movieapp.base.BaseViewModel
import com.gkreduction.domain.usecase.cinema.GetListMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var getListCinemaUseCase: GetListMoviesUseCase) :
    BaseViewModel<MainScreenViewState, MainScreenIntent>() {

    override fun getInitialState(): MainScreenViewState = MainScreenViewState()

    override fun processIntents(intent: MainScreenIntent) {
        when (intent) {
            MainScreenIntent.LoadCinemaData -> fetchMovies()
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            getListCinemaUseCase.execute().let {
                updateState { state ->
                    state.copy(items = it)
                }
            }
        }
    }

}


