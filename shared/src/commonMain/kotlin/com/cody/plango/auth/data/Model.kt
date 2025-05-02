package com.cody.plango.auth.data

import kotlinx.serialization.Serializable

@Serializable
internal data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    val full_name: String,
    val phone_number: String
)

@Serializable
internal data class AuthResponse(
    val msg: String,
    val user: UserData,
    val access_token: String,
    val token_type: String
)







@Serializable
internal data class UserData(
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val full_name: String,
    val phone_number: String
)
