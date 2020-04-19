package br.com.bersoncrios.covid19tracker.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.bersoncrios.covid19tracker.network.data.Country
import br.com.bersoncrios.covid19tracker.repos.RemoteRepository

class MyViewModel : ViewModel() {
    fun callAPI(context: Context) : MutableLiveData<Country> {
        return RemoteRepository().callAPI(context)
    }
}