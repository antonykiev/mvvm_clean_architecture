package com.example.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.domain.entity.Answer
import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.domain.logger.Logger
import com.example.cleanarchitecture.domain.usecase.CreateItemUseCase
import com.example.cleanarchitecture.domain.usecase.DeleteItemUseCase
import com.example.cleanarchitecture.domain.usecase.GetAnswerUseCase
import com.example.cleanarchitecture.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class TasksViewModel(
    private val getItemsUseCase: GetItemsUseCase,
    private val createItemUseCase: CreateItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    private val getAnswerUseCase: GetAnswerUseCase,
    private val logger: Logger
) : ViewModel() {

    private val _tasks = MutableLiveData<List<Item>>()
    val tasks: LiveData<List<Item>> = _tasks

    private val _answers = MutableLiveData<Answer>()
    val answers: LiveData<Answer> = _answers


    init {
        viewModelScope.launch {
            getItemsUseCase.execute()
                .catch { logger.d("TasksViewModel", "$it") }
                .collect { _tasks.postValue(it) }
        }
    }


    fun getAnswer() {
        viewModelScope.launch {
            val answer = getAnswerUseCase.execute()
            _answers.postValue(answer)
        }

    }

    fun create(description: String) {
        viewModelScope.launch {
            createItemUseCase.execute(description)
        }
    }

    fun delete(item: Item) {
        viewModelScope.launch {
            deleteItemUseCase.execute(item)
        }
    }

    public override fun onCleared() {
       super.onCleared()
    }
}