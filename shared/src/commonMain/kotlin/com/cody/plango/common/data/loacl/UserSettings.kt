package com.cody.plango.common.data.loacl

import com.cody.plango.auth.domain.model.AuthResultData
import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val id: Long = -1,
    val name: String = "",
    val bio: String = "",
    val avatar: String? = null,
    val token: String = "",
)

fun UserSettings.toAuthResultData(): AuthResultData{
    return AuthResultData(id, name, bio, avatar, token,)
}

fun AuthResultData.toUserSettings(): UserSettings {
    return UserSettings(
        id, name, bio, avatar, token
    )
}