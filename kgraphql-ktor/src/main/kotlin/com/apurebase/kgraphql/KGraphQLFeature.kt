package com.apurebase.kgraphql

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.route


fun Routing.graphql(
    block: SchemaBuilder<Unit>.() -> Unit
) = route("graphql") {
    val schema = KGraphQL.schema(block)
    val gson = Gson()

    post {
        val raw = context.receiveTextWithCorrectEncoding()
        val request = gson.fromJson(raw, GraphqlRequest::class.java)

        call.respondText(
            schema.execute(
                request = request.query ?: request.mutation ?: request.subscription!!,
                variables = gson.toJson(request.variables),
                context = context { /* TODO: Some support for context! */ }
            )
        )
    }
}


