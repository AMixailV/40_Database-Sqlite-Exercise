package ru.mixail_akulov.a40_database_sqlite_exercise

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.mixail_akulov.a40_database_sqlite_exercise.model.accounts.AccountsRepository
import ru.mixail_akulov.a40_database_sqlite_exercise.model.accounts.SQLiteAccountsRepository
import ru.mixail_akulov.a40_database_sqlite_exercise.model.boxes.BoxesRepository
import ru.mixail_akulov.a40_database_sqlite_exercise.model.boxes.SQLiteBoxesRepository
import ru.mixail_akulov.a40_database_sqlite_exercise.model.settings.AppSettings
import ru.mixail_akulov.a40_database_sqlite_exercise.model.settings.SharedPreferencesAppSettings

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: SQLiteDatabase by lazy<SQLiteDatabase> {
        TODO("#2 \n"
                + "Create a writable SQLiteDatabase object by using AppSQLiteHelper")
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

    val accountsRepository: AccountsRepository by lazy {
        SQLiteAccountsRepository(database, appSettings, ioDispatcher)
    }

    val boxesRepository: BoxesRepository by lazy {
        SQLiteBoxesRepository(database, accountsRepository, ioDispatcher)
    }

    fun init(context: Context) {
        applicationContext = context
    }
}