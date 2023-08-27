package com.gkreduction.cinemaapp.ui

import androidx.lifecycle.viewModelScope
import com.gkreduction.cinemaapp.base.BaseViewModel
import com.gkreduction.domain.entity.Movie
import com.gkreduction.domain.usecase.cinema.GetListMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var getListCinemaUseCase: GetListMoviesUseCase) :
    BaseViewModel<MainScreenViewState, MainScreenIntent>() {

    override fun getInitialState(): MainScreenViewState = MainScreenViewState()

    override fun processIntents(intent: MainScreenIntent) {
//        when (intent) {
//            MainScreenIntent.LoadCinemaData -> fetchMovies()
//        }
    }

     fun fetchMovies() {
        viewModelScope.launch {
            getListCinemaUseCase.execute().let {
                updateState { state ->
                    state.copy(items = it)
                }
            }
        }
    }

    private fun showItem(items: List<Movie>) {
        items.forEach {
            println(it.name)
            println(it.country)
        }

    }

}


data class MainScreenViewState(
    val items: List<Movie>? = null
)