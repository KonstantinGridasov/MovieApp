package com.gkreduction.domain.usecase

interface UseCase<T, R> {
    suspend fun execute(request: T? = null): R
}