package ru.mixail_akulov.a40_database_sqlite_exercise.screens.main.tabs.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.mixail_akulov.a40_database_sqlite_exercise.model.boxes.BoxesRepository
import ru.mixail_akulov.a40_database_sqlite_exercise.utils.MutableLiveEvent
import ru.mixail_akulov.a40_database_sqlite_exercise.utils.publishEvent
import ru.mixail_akulov.a40_database_sqlite_exercise.utils.share

class BoxViewModel(
    private val boxId: Long,
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _shouldExitEvent = MutableLiveEvent<Boolean>()
    val shouldExitEvent = _shouldExitEvent.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxes(onlyActive = true)
                .map { boxes -> boxes.firstOrNull { it.id == boxId } }
                .collect { currentBox ->
                    _shouldExitEvent.publishEvent(currentBox == null)
                }
        }
    }
}