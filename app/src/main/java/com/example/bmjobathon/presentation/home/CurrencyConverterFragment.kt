package com.example.bmjobathon.presentation.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.bmjobathon.base.BaseFragment
import com.example.bmjobathon.data.remote.dto.getFieldNames
import com.example.bmjobathon.databinding.FragmentCurrencyConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyConverterFragment @Inject constructor() : BaseFragment() {
    private var _binding: FragmentCurrencyConverterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CurrencyConverterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyConverterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()

        viewModel.rates.observe(viewLifecycleOwner) {
            val listOfCurrencies = getFieldNames<String>()
            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.simple_spinner_item,
                listOfCurrencies
            )

            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Apply the adapter to the spinner
            binding.spnFrom.adapter = adapter
            binding.spnrTo.adapter = adapter
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
