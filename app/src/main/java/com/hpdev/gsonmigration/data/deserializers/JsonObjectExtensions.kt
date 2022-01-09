package com.hpdev.gsonmigration.data.deserializers

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

inline fun <reified T : Any> JsonObject.getNotNull(memberName: String): T =
    getOrNull(memberName)
        ?: throw JsonParseException("$memberName should be not null but is not present in the response or is null")

inline fun <reified T : Any> JsonObject.getOrNull(memberName: String): T? =
    when (T::class) {
        JsonObject::class -> toKotlinNullable(memberName)?.asJsonObject as? T
        JsonArray::class -> toKotlinNullable(memberName)?.asJsonArray as? T
        JsonPrimitive::class -> toKotlinNullable(memberName)?.asJsonPrimitive as? T
        String::class -> toKotlinNullable(memberName)?.asString as? T
        Boolean::class -> toKotlinNullable(memberName)?.asBoolean as? T
        Int::class -> toKotlinNullable(memberName)?.asInt as? T
        Long::class -> toKotlinNullable(memberName)?.asLong as? T
        else -> throw JsonParseException("Item type not supported")
    }

fun JsonObject.toKotlinNullable(memberName: String): JsonElement? =
    get(memberName)?.takeIf { !it.isJsonNull }

inline fun <reified T> getType(): Type = object : TypeToken<T>() {}.type
