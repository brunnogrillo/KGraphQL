package com.apurebase.kgraphql

import io.ktor.server.testing.TestApplicationEngine
import io.ktor.server.testing.withTestApplication

abstract class ServerTest {

    fun <T> withServer(block: TestApplicationEngine.() -> T): T {
        return withTestApplication({ module() }) { block(this) }
    }

}
