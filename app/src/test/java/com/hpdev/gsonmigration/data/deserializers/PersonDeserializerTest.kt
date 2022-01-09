package com.hpdev.gsonmigration.data.deserializers

import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import com.hpdev.gsonmigration.data.dto.AddressDTO
import com.hpdev.gsonmigration.data.dto.PersonDTO
import junit.framework.TestCase.assertEquals
import org.junit.Test

class PersonDeserializerTest {

    private val sut = GsonBuilder().registerDeserializers().create()

    @Test
    fun `Should deserialize a complete response`() {

        val json =
            """
          {
               id: "id",
               name: "name",
               surname: "surname",
               address: {
                    street: "street",
                    number: 1
               }
          
          }
        """.trimIndent()

        val expected = PersonDTO(
            id = "id",
            name = "name",
            surname = "surname",
            address = AddressDTO(
                street = "street",
                number = 1
            )
        )

        val actual = sut.fromJson(json, PersonDTO::class.java)

        assertEquals(expected, actual)
    }

    @Test(expected = JsonParseException::class)
    fun `Should throw an exception if the id field is missing`() {

        val json =
            """
          {
               name: "name",
               surname: "surname",
               address: {
                    street: "street",
                    number: 1
               }
          
          }
        """.trimIndent()

        sut.fromJson(json, PersonDTO::class.java)
    }
}
