package com.hpdev.gsonmigration.domain

data class Person(
    val id: String,
    val name: String,
    val surname: String,
    val address: Address?
)

data class Address(
    val street: String,
    val number: Int,
)