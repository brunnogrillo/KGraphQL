package com.apurebase.kgraphql

import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    routing {
        graphql {
            query("hello") {
                resolver { -> "test" /*""${who ?: "World"}!"*/ }
            }
        }
    }
}
