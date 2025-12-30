/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

class NavigatorRender(
    val key: String? = null,
    val parameters: MutableMap<String, Any> = mutableMapOf()
) {

    fun put(key: String, value: Any) {
        parameters[key] = value
    }

    fun getBoolean(key: String): Boolean? {
        val value = parameters[key]
        if (value is Boolean) {
            return value
        }
        return null
    }

    fun getLong(key: String): Long? {
        val value = parameters[key]
        if (value is Long) {
            return value
        }
        return null
    }

    fun getString(key: String): String? {
        val value = parameters[key]
        if (value is String) {
            return value
        }
        return null
    }

    inline fun <reified T> get(key: String): T? {
        val value = parameters[key]
        if (value is T) {
            return value
        }
        return null
    }
}
