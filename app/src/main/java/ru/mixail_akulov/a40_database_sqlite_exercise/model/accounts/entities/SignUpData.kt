package ru.mixail_akulov.a40_database_sqlite_exercise.model.accounts.entities

import ru.mixail_akulov.a40_database_sqlite_exercise.model.EmptyFieldException
import ru.mixail_akulov.a40_database_sqlite_exercise.model.Field
import ru.mixail_akulov.a40_database_sqlite_exercise.model.PasswordMismatchException

/**
 * Fields that should be provided during creating a new account.
 */
data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}