package com.gkreduction.domain.entity

sealed class ResultData<T> {
    data class Success<T>(val data: T) : ResultData<T>()

    data class Error<T>(val errorType: ErrorType) : ResultData<T>()
}

enum class ErrorType {
    CLIENT,
    SERVER,
    GENERIC,
    IO_CONNECTION,
    UNAUTHORIZED
}

