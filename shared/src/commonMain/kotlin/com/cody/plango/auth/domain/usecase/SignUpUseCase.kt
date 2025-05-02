package com.cody.plango.auth.domain.usecase

import com.cody.plango.auth.domain.repository.AuthRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.cody.plango.common.util.Result
import com.cody.plango.auth.domain.model.AuthResultData





class SignUpUseCase: KoinComponent {
    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        username: String,
        fullName : String,
        email: String,
        phoneNumber: String,
        password: String,
    ): Result<AuthResultData>{
        if (username.isBlank() || username.length < 3){
            return Result.Error(
                message = "Invalid name"
            )
        }
        if (email.isBlank() || "@" !in email){
            return Result.Error(
                message = "Invalid email"
            )
        }
        if (password.isBlank() || password.length < 4){
            return Result.Error(
                message = "Invalid password or too short!"
            )
        }

        return repository.signUp(username,fullName, email,phoneNumber, password)
    }
}
