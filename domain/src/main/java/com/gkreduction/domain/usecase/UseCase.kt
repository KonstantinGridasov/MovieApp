package com.gkreduction.domain.usecase

interface UseCase<T, R> {
    fun execute(request: T?): R
}