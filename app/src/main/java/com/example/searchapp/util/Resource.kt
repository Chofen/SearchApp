package com.example.searchapp.util

import okhttp3.ResponseBody

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Resource<T> (val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
