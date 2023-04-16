package com.jongyun.springconverter

fun String?.isNumber(): Boolean {
    return try {
        this?.toLong()
        true
    } catch (e: Exception) {
        false
    }
}