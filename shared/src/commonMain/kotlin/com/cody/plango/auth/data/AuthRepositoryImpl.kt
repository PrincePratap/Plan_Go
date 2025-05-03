package com.cody.plango.auth.data

import com.cody.plango.auth.domain.model.AuthResultData
import com.cody.plango.auth.domain.repository.AuthRepository
import com.cody.plango.common.util.DispatcherProvider
import kotlinx.coroutines.withContext
import com.cody.plango.common.util.Result

internal class AuthRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService,
//    private val userPreferences: UserPreferences
) : AuthRepository {

    companion object {
        private const val TAG = "AuthRepositoryImpl"
    }

    override suspend fun signUp(
        username: String,
        fullName: String,
        email: String,
        phoneNumber: String,
        password: String
    ): Result<AuthResultData> = withContext(dispatcher.io) {
        try {
            println("🟡 [AuthRepository] SignUp started")
            println("➡️ Request Data: username=$username, fullName=$fullName, email=$email, phone=$phoneNumber")

            val request = RegisterRequest(
                username = username,
                email = email,
                password = password,
                full_name = fullName,
                phone_number = phoneNumber
            )

            println("📤 Sending request: $request")

            val registerResponse = authService.register(request)

            println("✅ Received response: accessToken=${registerResponse.access_token}, user=${registerResponse.user}")

//            userPreferences.setUserData(
//                registerResponse.user.toAuthResultData(registerResponse.access_token).toUserSettings()
//            )

            val result = Result.Success(
                data = registerResponse.user.toAuthResultData(registerResponse.access_token)
            )

            println("🎯 Mapped to AuthResultData: $result")
            println("🟢 [AuthRepository] SignUp completed successfully")

            result
        } catch (e: Exception) {
            println("❌ [AuthRepository] Exception during sign up: ${e.message}")
            e.printStackTrace()

            Result.Error(
                message = "Oops, something went wrong!"
            )
        }
    }

    override suspend fun signIn(email: String, password: String): Result<AuthResultData> {
        TODO("Not yet implemented")
    }
}
