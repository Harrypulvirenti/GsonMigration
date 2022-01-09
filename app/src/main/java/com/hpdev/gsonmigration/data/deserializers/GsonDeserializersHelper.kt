package com.hpdev.gsonmigration.data.deserializers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hpdev.gsonmigration.data.dto.AddressDTO
import com.hpdev.gsonmigration.data.dto.PersonDTO

fun GsonBuilder.registerDeserializers() =
    registerTypeAdapter(PersonDTO::class.java, PersonDeserializer())
        .registerTypeAdapter(AddressDTO::class.java, AddressDeserializer())

val gsonInstance: Gson =
    GsonBuilder()
        .registerDeserializers()
        .create()
