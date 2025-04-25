package com.cody.plango.android.di

import com.cody.plango.android.auth.Login.LoginViewModel
import com.cody.plango.android.auth.signup.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel() }
    viewModel { SignUpViewModel() }
//    viewModel { MainActivityViewModel(get())}
//    viewModel { HomeScreenViewModel(get(), get(), get(), get())}
//    viewModel { PostDetailViewModel(get(), get(), get(), get(), get())}
//    viewModel { ProfileViewModel(get(), get(), get(), get()) }
//    viewModel { EditProfileViewModel(get(), get(), get()) }
//    viewModel { FollowsViewModel(get()) }
//    single { ImageBytesReader(androidContext()) }
//    viewModel { CreatePostViewModel(get(), get()) }
}
