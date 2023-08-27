package com.gkreduction.cinemaapp.ui

sealed class MainScreenIntent {
    object LoadCinemaData : MainScreenIntent()

//    data class DisplayCinemaName(val cityName: String) : MainScreenIntent()
}