package com.apurebase.kgraphql

import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.charset
import io.ktor.request.contentType
import io.ktor.request.receiveStream
import java.nio.charset.Charset

/**
 * Receive the request as String.
 * If there is no Content-Type in the HTTP header specified use ISO_8859_1 as default charset, see https://www.w3.org/International/articles/http-charset/index#charset.
 * But use UTF-8 as default charset for application/json, see https://tools.ietf.org/html/rfc4627#section-3
 */
internal suspend fun ApplicationCall.receiveTextWithCorrectEncoding(): String {
    fun ContentType.defaultCharset(): Charset = when (this) {
        ContentType.Application.Json -> Charsets.UTF_8
        else -> Charsets.ISO_8859_1
    }

    val contentType = request.contentType()
    val suitableCharset = contentType.charset() ?: contentType.defaultCharset()
    return receiveStream().bufferedReader(charset = suitableCharset).readText()
}
