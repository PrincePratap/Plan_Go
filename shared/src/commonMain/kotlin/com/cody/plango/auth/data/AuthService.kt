package com.cody.plango.auth.data

import com.cody.plango.common.data.remote.KtorApi
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class AuthService: KtorApi() {

    suspend fun register(request: RegisterRequest): AuthResponse = client.post {
        endPoint(path = "register")
        setBody(request)
    }.body()


}