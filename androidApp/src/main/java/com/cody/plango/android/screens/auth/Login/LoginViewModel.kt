package com.cody.plango.android.screens.auth.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel (): ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun signIn(){
//        viewModelScope.launch {
//            uiState = uiState.copy(isAuthenticating = true)
//
//            val authResultData = signInUseCase(uiState.email, uiState.password)
//
//            uiState = when(authResultData){
//                is Result.Error -> {
//                    uiState.copy(
//                        isAuthenticating = false,
//                        authErrorMessage = authResultData.message
//                    )
//                }
//                is Result.Success -> {
//                    uiState.copy(
//                        isAuthenticating = false,
//                        authenticationSucceed = true
//                    )
//                }
//            }
//        }
    }

    fun updateEmail(input: String){
        uiState = uiState.copy(email = input)
    }

    fun updatePassword(input: String){
        uiState = uiState.copy(password = input)
    }
}

data class LoginUiState(
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucceed: Boolean = false
)


