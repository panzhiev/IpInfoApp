package com.panzhiev.data

import com.panzhiev.domain.model.Result
import java.lang.Exception
import javax.inject.Inject

class ResultHandler @Inject constructor() {
    suspend operator fun <T> invoke(block: suspend () -> T): Result<T> =
        try {
            Result.Success(block())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "")
        }
}