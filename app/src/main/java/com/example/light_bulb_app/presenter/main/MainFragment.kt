package com.example.light_bulb_app.presenter.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.light_bulb_app.R
import com.example.light_bulb_app.UiState
import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import com.example.light_bulb_app.databinding.FragmentMainBinding
import com.example.light_bulb_app.di.appComponent
import com.example.light_bulb_app.di.viewModel.ViewModelFactory
import javax.inject.Inject


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.lampState.observe(viewLifecycleOwner){
            when(it){
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> initializeButton(it.value!!)
            }
        }

        viewModel.lampColors.observe(viewLifecycleOwner){
            when(it){
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> initializeSpinner(it.value!!)
            }
        }

        viewModel.lampBrightnessLevels.observe(viewLifecycleOwner){
            when(it){
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> initializeNumberPicker(it.value!!)
            }
        }

        viewModel.lampBrightness.observe(viewLifecycleOwner){
            when(it){
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> setBrightness(it.value!!)
            }
        }
        viewModel.lampColor.observe(viewLifecycleOwner){
            when(it){
                is UiState.Failure -> {}
                is UiState.Loading -> {}
                is UiState.Success -> setColor(it.value!!)
            }
        }

        viewModel.loadBrightnessLevels()
        viewModel.loadColors()
        viewModel.loadState()

    }

    private fun initializeButton(state: Boolean){
        if (state) binding.onOffButton.setOnClickListener{
            viewModel.offLamp()
            viewModel.loadState()
        }
        else binding.onOffButton.setOnClickListener{
            viewModel.onLamp()
            viewModel.loadBrightnessLevels()
            viewModel.loadColors()
            viewModel.loadState()
        }
    }

    private fun initializeSpinner(currencies: List<Color>){
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item , currencies.map{it.color})
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.colorsDropdown.setAdapter(adapter)
        binding.colorsDropdown.setOnItemClickListener { adapterView, _, i, _ ->
            val item: String = adapterView.getItemIdAtPosition(i).toString()
            viewModel.setColor(item)
            viewModel.loadColor()
        }
    }

    private fun initializeNumberPicker(brightnessLevels: BrightnessLevels){
        binding.numberPicker.minValue = brightnessLevels.min
        binding.numberPicker.maxValue = brightnessLevels.max
        binding.numberPicker.setOnValueChangedListener { _, _, newVal ->
            viewModel.setBrightness(newVal)
            viewModel.loadBrightness()
        }
    }

    private fun setColor(color: Color){
        binding.colorsDropdown.setText(color.color, false)
    }

    private fun setBrightness(level: Int){
        binding.numberPicker.value = level
    }
}