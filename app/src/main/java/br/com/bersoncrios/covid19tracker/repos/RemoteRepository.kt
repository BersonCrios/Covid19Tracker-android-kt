package br.com.bersoncrios.covid19tracker.repos

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import br.com.bersoncrios.covid19tracker.network.data.Country
import br.com.bersoncrios.covid19tracker.ui.interfaces.RetrofitApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    fun callAPI(context: Context): MutableLiveData<Country> {
        val mutableLiveData = MutableLiveData<Country>()
        RetrofitApiService().covidService().fetchData()
            .enqueue(object : Callback<Country> {
                override fun onFailure(call: Call<Country>, t: Throwable) {
                    Log.d("Error", "Coudn't get the data")
                    Toast.makeText(context, "Não foi possivel carregar os dados", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(call: Call<Country>, response: Response<Country>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())
                    } else {
                        Log.d("Error", "Coudn't get the data")
                    }

                }
            })
        return mutableLiveData
    }
}