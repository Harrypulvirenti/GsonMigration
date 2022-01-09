package com.hpdev.gsonmigration.data.dto

// Gson Objects
data class PersonDTO(
    val id: String,
    val name: String,
    val surname: String,
    val address: AddressDTO?
)

data class AddressDTO(
    val street: String,
    val number: Int,
)


