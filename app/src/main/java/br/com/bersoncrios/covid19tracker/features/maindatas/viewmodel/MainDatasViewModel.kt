package br.com.bersoncrios.covid19tracker.features.maindatas.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.bersoncrios.covid19tracker.network.data.model.Country
import br.com.bersoncrios.covid19tracker.repositories.MainDatasRepository

class MainDatasViewModel : ViewModel() {
    fun callAPI(context: Context) : MutableLiveData<Country> {
        return MainDatasRepository().callAPI(context)
    }
}