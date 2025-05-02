package com.cody.plango.auth.domain.repository

import com.cody.plango.auth.domain.model.AuthResultData
import com.cody.plango.common.util.Result



internal interface AuthRepository {

    suspend fun signUp(
        username: String,
        fullName : String,
        email: String,
        phoneNumber: String,
        password: String,
    ): Result<AuthResultData>

//    suspend fun signIn(username: String,fullName: String,email: String,phoneNumber: String, password: String): Result<AuthResultData>
}