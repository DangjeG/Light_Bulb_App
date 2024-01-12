package com.example.light_bulb_app.presenter.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.light_bulb_app.UiState
import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import com.example.light_bulb_app.domain.*
import com.example.light_bulb_app.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val onLampUseCase: OnLampUseCase,
    private val offLampUseCase: OffLampUseCase,
    private val getStateUseCase: GetStateUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val getColorUseCase: GetColorUseCase,
    private val getBrightnessLevelsUseCase: GetBrightnessLevelsUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
    private val getBrightnessUseCase: GetBrightnessUseCase,

) : ViewModel() {
    private val _lampState = MutableLiveData<UiState<Boolean?>>(UiState.Loading)
    private val _lampColor = MutableLiveData<UiState<Color?>>(UiState.Loading)
    private val _lampBrightness = MutableLiveData<UiState<Int?>>(UiState.Loading)

    private val _lampBrightnessLevels = MutableLiveData<UiState<BrightnessLevels?>>(UiState.Loading)
    private val _lampColors = MutableLiveData<UiState<List<Color>?>>(UiState.Loading)

    val lampState: LiveData<UiState<Boolean?>>
    get() = _lampState

    val lampColor: LiveData<UiState<Color?>>
        get() = _lampColor

    val lampBrightness: LiveData<UiState<Int?>>
        get() = _lampBrightness

    val lampBrightnessLevels: LiveData<UiState<BrightnessLevels?>>
        get() = _lampBrightnessLevels

    val lampColors: LiveData<UiState<List<Color>?>>
        get() = _lampColors
    fun loadState() {
        viewModelScope.launch {
            val result = getStateUseCase()
            _lampState.postValue(result.toUiState())
        }
    }

    fun loadColor() {
        viewModelScope.launch {
            val result = getColorUseCase()
            _lampColor.postValue(result.toUiState())
        }
    }

    fun loadBrightness() {
        viewModelScope.launch {
            val result = getBrightnessUseCase()
            _lampBrightness.postValue(result.toUiState())
        }
    }

    fun loadBrightnessLevels() {
        viewModelScope.launch {
            val result = getBrightnessLevelsUseCase()
            _lampBrightnessLevels.postValue(result.toUiState())
        }
    }

    fun loadColors() {
        viewModelScope.launch {
            val result = getColorsUseCase()
            _lampColors.postValue(result.toUiState())
        }
    }

    fun onLamp() {
        viewModelScope.launch {
            onLampUseCase()
        }
    }
    fun offLamp() {
        viewModelScope.launch {
            offLampUseCase()
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }

    fun setBrightness(level: Int) {
        viewModelScope.launch {
            setBrightnessUseCase(level)
        }
    }
}