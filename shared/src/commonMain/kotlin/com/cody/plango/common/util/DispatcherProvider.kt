package com.cody.plango.common.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

internal expect fun provideDispatcher(): DispatcherProvider