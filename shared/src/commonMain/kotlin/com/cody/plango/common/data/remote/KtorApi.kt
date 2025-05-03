package com.cody.plango.common.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://13.61.22.63/"

internal abstract class KtorApi {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            contentType(ContentType.Application.Json)
        }
        println("✅ [KtorApi] Endpoint set to: $BASE_URL$path")
    }

    fun HttpRequestBuilder.setToken(token: String) {
        headers {
            append(name = "Authorization", value = "Bearer $token")
        }
        println("🔐 [KtorApi] Authorization header set: Bearer $token")
    }

    fun HttpRequestBuilder.setupMultipartRequest() {
        contentType(ContentType.MultiPart.FormData)
        println("📦 [KtorApi] Request type set to Multipart/Form-Data")
    }
}
