package com.cody.plango.auth.data

import com.cody.plango.auth.domain.model.AuthResultData

internal fun UserData.toAuthResultData(token: String): AuthResultData {
    return AuthResultData(
        id = id.toLongOrNull() ?: 0L,
        name = full_name,
        bio = "",
        avatar = null,
        token = token,

    )
}
