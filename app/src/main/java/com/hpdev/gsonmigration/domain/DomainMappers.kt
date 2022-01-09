package com.hpdev.gsonmigration.domain

import com.hpdev.gsonmigration.data.dto.AddressDTO
import com.hpdev.gsonmigration.data.dto.PersonDTO

fun PersonDTO.toDomain(): Person {
    if (id == null || name == null || surname == null) {
        // throw an exception in a controlled manner
        // or use default value if possible
        throw RuntimeException("Some field is null")
    } else {
        return Person(
            id,
            name,
            surname,
            address?.toDomain()
        )
    }
}

fun AddressDTO.toDomain(): Address {
    if (street == null || number == null) {
        // throw an exception in a controlled manner
        // or use default value if possible
        throw RuntimeException("Some field is null")
    } else {
        return Address(
            street,
            number
        )
    }
}