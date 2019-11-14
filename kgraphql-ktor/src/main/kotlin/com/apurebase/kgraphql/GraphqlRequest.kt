package com.apurebase.kgraphql

data class GraphqlRequest(
    val query: String?,
    val mutation: String?,
    val subscription: String?,
    val variables: Map<String, Any?>?
)
