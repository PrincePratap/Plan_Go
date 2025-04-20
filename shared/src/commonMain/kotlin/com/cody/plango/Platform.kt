package com.cody.plango

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform