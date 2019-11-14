package com.apurebase.kgraphql

import com.apurebase.kgraphql.schema.Schema
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder


class KGraphQL {
    companion object {
        fun schema(init: SchemaBuilder<Unit>.() -> Unit): Schema {
            return SchemaBuilder<Unit>()
                .apply(init)
                .build()
        }
    }
}
