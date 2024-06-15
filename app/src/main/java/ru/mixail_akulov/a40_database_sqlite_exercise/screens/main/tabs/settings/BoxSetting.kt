package ru.mixail_akulov.a40_database_sqlite_exercise.screens.main.tabs.settings

import ru.mixail_akulov.a40_database_sqlite_exercise.model.boxes.entities.Box

data class BoxSetting(
    val box: Box,
    val enabled: Boolean
)