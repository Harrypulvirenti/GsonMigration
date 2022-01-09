package com.hpdev.gsonmigration.data.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.hpdev.gsonmigration.data.dto.AddressDTO
import java.lang.reflect.Type

class AddressDeserializer : JsonDeserializer<AddressDTO> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): AddressDTO = with(json.asJsonObject) {
        AddressDTO(
            street = getNotNull("street"),
            number = getNotNull("number")
        )
    }
}