package com.example.marvel_clean_architecture.framework

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    val ts = Timestamp(System.currentTimeMillis()).time.toString()

    const val API_KEY = "INSERT_KEY_HERE"

    const val PRIVATE_KEY = "INSERT_KEY_HERE"

    fun generateMd5Hash(): String {
        val input = "$ts$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}