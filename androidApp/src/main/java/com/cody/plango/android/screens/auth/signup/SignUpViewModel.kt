package com.cody.plango.android.screens.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cody.plango.auth.domain.usecase.SignUpUseCase
import kotlinx.coroutines.launch
import com.cody.plango.common.util.Result

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    var uiState by mutableStateOf(SignUpUiState())
        private set

    fun signUp() {
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val authResultData = signUpUseCase(uiState.username, uiState.fullName, uiState.email, uiState.phoneNumber, uiState.password)

            uiState = when(authResultData){
                is Result.Error -> {
                    uiState.copy(
                        isAuthenticating = false,
                        authErrorMessage = authResultData.message
                    )
                }
                is Result.Success -> {
                    uiState.copy(
                        isAuthenticating = false,
                        authenticationSucceed = true
                    )
                }
            }
        }
    }



    fun updateUsername(input: String){
        uiState = uiState.copy(username = input)
    }

    fun updateFullName(input: String){
        uiState = uiState.copy(fullName = input)
    }

    fun updatePhoneNumber(input: String){
        uiState = uiState.copy(phoneNumber = input)
    }


    fun updateEmail(input: String){
        uiState = uiState.copy(email = input)
    }

    fun updatePassword(input: String){
        uiState = uiState.copy(password = input)
    }
}

data class SignUpUiState(
    var username: String = "",
    var email: String = "",
    val fullName: String = "",
    var password: String = "",
    val phoneNumber: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucceed: Boolean = false
)

