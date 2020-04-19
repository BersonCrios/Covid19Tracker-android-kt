package br.com.bersoncrios.covid19tracker.repositories

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import br.com.bersoncrios.covid19tracker.network.data.model.Country
import br.com.bersoncrios.covid19tracker.network.data.model.GlobalData
import br.com.bersoncrios.covid19tracker.network.services.RetrofitApiService
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainDatasRepository {
    fun callAPI(context: Context): MutableLiveData<Country> {
        val mutableLiveData = MutableLiveData<Country>()
        RetrofitApiService().covidService().fetchData()
            .enqueue(object : Callback<Country> {
                override fun onFailure(call: Call<Country>, t: Throwable) {
                    Log.e("Error", t.message)
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

    fun listMainDatas(context: Context): @NonNull Observable<List<GlobalData>>? {
        return RetrofitApiService().covidService().fetchDataRx()
            .flatMap {
                    countriesResult -> Observable.fromArray(countriesResult.Countries)
            }
    }
}