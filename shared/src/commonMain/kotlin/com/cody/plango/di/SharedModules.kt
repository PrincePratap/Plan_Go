package com.cody.plango.di

import com.cody.plango.auth.data.AuthRepositoryImpl
import com.cody.plango.auth.data.AuthService
import com.cody.plango.auth.domain.repository.AuthRepository
import com.cody.plango.auth.domain.usecase.SignInUseCase
import com.cody.plango.auth.domain.usecase.SignUpUseCase
import com.cody.plango.common.util.provideDispatcher
import org.koin.dsl.module

private val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { AuthService() }
    factory { SignUpUseCase() }
    factory { SignInUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(
//    platformModule,
    authModule,
    utilityModule,
//    postModule,
//    followsModule,
//    accountModule,
//    postCommentModule
)
