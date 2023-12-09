package com.example.bmjobathon.presentation.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmjobathon.domain.repository.DataRepo
import com.example.bmjobathon.data.remote.dto.Rate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val dataRepo: DataRepo
) : ViewModel() {


    private val _rates = MutableLiveData<Rate>()

    val rates: LiveData<Rate> get() = _rates
    fun getData() {
        viewModelScope.launch(IO) {
            val res = dataRepo.getRates()
            withContext(Dispatchers.Main) {
                _rates.value = res.data?.rates
            }
        }
    }





}
