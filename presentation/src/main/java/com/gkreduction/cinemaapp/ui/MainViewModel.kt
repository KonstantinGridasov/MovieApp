package com.gkreduction.cinemaapp.ui

import androidx.lifecycle.ViewModel
import com.gkreduction.domain.usecase.cinema.GetListCinemaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var getListCinemaUseCase: GetListCinemaUseCase) :
    ViewModel() {
        
    }