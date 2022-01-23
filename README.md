# Gson Migration Strategy - Practical guide

In this repository, you will find the code examples of a migration strategy from `Gson` to `Kotlin x Serialization`.

This strategy is detailed described in [this article](https://dev.to/harrypulvirenti/gson-migration-made-easy-3b31).

The examples are split into different branches per step:

- Fix DTOs fields nullability
- Implement a Custom Deserializers
- Register the deserializers to the `Gson` instance and deserializers tests
- Finalise the migration to `Kotlin x Serialization`

For details about the advantages of this strategy refer to the provided article above.
