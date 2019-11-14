package com.apurebase.kgraphql

import io.ktor.http.HttpMethod
import io.ktor.server.testing.setBody
import me.lazmaid.kraph.Kraph
import org.junit.Test

class BasicQueryTest: ServerTest() {

    @Test
    fun `Basic request returning graphql data`() {
        withServer {
//            handleRequest {
//                uri = "/graphql"
//                method = HttpMethod.Post
//
//                val query = Kraph {
//                    query {
//                        field("hello")
//                    }
//                }
//
//                setBody(query.toRequestString())
//            }
        }
    }

}
