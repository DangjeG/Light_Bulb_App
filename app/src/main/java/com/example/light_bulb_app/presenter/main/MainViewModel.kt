package com.example.light_bulb_app.presenter.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.light_bulb_app.UiState
import com.example.light_bulb_app.data.model.Resp
import com.example.light_bulb_app.domain.GetJokesCategoriesUseCase
import com.example.light_bulb_app.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getJokesCategoriesUseCase: GetJokesCategoriesUseCase,
) : ViewModel() {
    private val _liveData = MutableLiveData<UiState<Resp?>>(UiState.Loading)
    val liveData: LiveData<UiState<Resp?>>
        get() = _liveData

    fun loadData() {
        viewModelScope.launch {
            val jokesCategoriesResult = getJokesCategoriesUseCase()
            _liveData.postValue(jokesCategoriesResult.toUiState())
        }
    }
}