package com.example.light_bulb_app.presenter.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.light_bulb_app.R
import com.example.light_bulb_app.UiState
import com.example.light_bulb_app.data.model.Resp
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

        viewModel.liveData.observe(viewLifecycleOwner) {
            onDataReceived(it)
        }
        viewModel.loadData()
    }


    private fun onDataReceived(jokesCategories: UiState<Resp?>) {
        when(jokesCategories) {
            is UiState.Success -> {
                binding.text.text = jokesCategories.value?.rates?.get("USD").toString()
            }
            is UiState.Failure -> {
                binding.text.text = "error"
            }
            is UiState.Loading -> {
                binding.text.text = "load"
            }
            else -> {}
        }
    }

}