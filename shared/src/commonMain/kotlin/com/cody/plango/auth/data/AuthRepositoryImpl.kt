package com.cody.plango.auth.data

import androidx.media3.common.util.Log
import com.cody.plango.auth.domain.model.AuthResultData
import com.cody.plango.auth.domain.repository.AuthRepository
import com.cody.plango.common.util.DispatcherProvider
import kotlinx.coroutines.withContext
import com.cody.plango.common.data.loacl.UserPreferences
import com.cody.plango.common.data.loacl.toUserSettings
import com.cody.plango.common.util.Result


internal class AuthRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService,
    private val userPreferences: UserPreferences
) : AuthRepository {
    override suspend fun signUp(
        username: String,
        fullName : String,
        email: String,
        phoneNumber: String,
        password: String,

        ): Result<AuthResultData> {
        return withContext(dispatcher.io){
            try {



                val request = RegisterRequest(username, email, password,fullName, phoneNumber)

                val registerResponse = authService.register(request)

                userPreferences.setUserData(
                    registerResponse.user.toAuthResultData(registerResponse.access_token).toUserSettings()
                )

                Result.Success(
                    data = registerResponse.user.toAuthResultData(registerResponse.access_token)
                )

            } catch (e: Exception){
                Result.Error(
                    message =  "Oops, something went wrong!"
                )
            }
        }
    }

//    override suspend fun signIn(
//        username: String,
//        fullName: String,
//        email: String,
//        phoneNumber: String,
//        password: String
//    ): kotlin.Result<AuthResultData> {
//        TODO("Not yet implemented")
//    }


}