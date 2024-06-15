package ru.mixail_akulov.a40_database_sqlite_exercise.model.sqlite

import android.database.sqlite.SQLiteException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import ru.mixail_akulov.a40_database_sqlite_exercise.model.StorageException

/**
 * Converts any [SQLiteException] into in-app [StorageException]
 */
suspend fun <T> wrapSQLiteException(dispatcher: CoroutineDispatcher, block: suspend CoroutineScope.() -> T): T {
    try {
        return withContext(dispatcher, block)
    } catch (e: SQLiteException) {
        val appException = StorageException()
        appException.initCause(e)
        throw appException
    }
}