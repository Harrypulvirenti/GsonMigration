package com.hpdev.gsonmigration.data.dto

import kotlinx.serialization.Serializable

// Kotlinx Serialization Objects
@Serializable
data class PersonDTO(
    val id: String,
    val name: String,
    val surname: String,
    val address: AddressDTO?
)

@Serializable
data class AddressDTO(
    val street: String,
    val number: Int,
)


