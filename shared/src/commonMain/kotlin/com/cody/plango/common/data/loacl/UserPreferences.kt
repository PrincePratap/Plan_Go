package com.cody.plango.common.data.loacl



internal const val PREFERENCES_FILE_NAME = "app_user_settings.preferences_pb"
internal interface UserPreferences{
    suspend fun getUserData(): UserSettings
    suspend fun setUserData(userSettings: UserSettings)
}