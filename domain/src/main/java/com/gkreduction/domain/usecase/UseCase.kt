package com.gkreduction.domain.usecase

import com.gkreduction.domain.entity.ResultData

interface UseCase<T, R> {
    suspend  fun  execute(request: T?): ResultData<R>
}