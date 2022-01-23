package com.hpdev.gsonmigration.data.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.hpdev.gsonmigration.data.dto.AddressDTO
import com.hpdev.gsonmigration.data.dto.PersonDTO
import java.lang.reflect.Type

class PersonDeserializer : JsonDeserializer<PersonDTO> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): PersonDTO = with(json.asJsonObject) {
        PersonDTO(
            id = getNotNull("id"),
            name = getNotNull("name"),
            surname = getNotNull("surname"),
            address = deserializeAddressDTO(context)
        )
    }

    private fun JsonObject.deserializeAddressDTO(context: JsonDeserializationContext): AddressDTO? =
        context.deserialize(getOrNull<JsonObject>("address"), getType<AddressDTO>())
}
