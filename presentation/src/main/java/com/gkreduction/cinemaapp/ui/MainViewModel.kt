package com.gkreduction.cinemaapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkreduction.domain.entity.Cinema
import com.gkreduction.domain.usecase.cinema.GetListCinemaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var getListCinemaUseCase: GetListCinemaUseCase) :
    ViewModel() {


    fun test() {
        viewModelScope.launch {
            val items = getListCinemaUseCase.execute()
            showItem(items)
        }
    }

    private fun showItem(items: List<Cinema>) {
        items.forEach {
            println(it.name)
            println(it.country)
        }

    }
}