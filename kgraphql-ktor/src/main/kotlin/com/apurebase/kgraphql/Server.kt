package com.apurebase.kgraphql

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.time.Duration

fun main() = embeddedServer(Netty, 8080) {

    install(CORS) {
        method(HttpMethod.Options)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.Authorization)
        header(HttpHeaders.AccessControlRequestHeaders)
        header(HttpHeaders.AccessControlRequestMethod)
        header("x-apollo-tracing")
        anyHost()
        maxAge = Duration.ofDays(1)
    }

    routing {

        graphql {
            query("hello") {
                resolver { who: String? -> who ?: "World" }
            }
        }



        get("/") { call.respondText("Hello World") }
    }
}.start(wait = true).let {}

