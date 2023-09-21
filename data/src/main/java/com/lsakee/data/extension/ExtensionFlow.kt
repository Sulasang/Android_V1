package com.lsakee.data.extension

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

@OptIn(ExperimentalCoroutinesApi::class)
fun <T, R> Flow<T>.flatMapDomain(domainMapper: suspend (T) -> R): Flow<R> {
    return this.flatMapConcat { data ->
        flow {
            emit(domainMapper(data))
        }
    }
}