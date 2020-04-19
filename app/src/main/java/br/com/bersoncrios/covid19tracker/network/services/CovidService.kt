package br.com.bersoncrios.covid19tracker.network.services

import br.com.bersoncrios.covid19tracker.network.data.model.Country
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {
    @GET("summary")
    fun fetchData(): Call<Country>

    @GET("summary")
    fun fetchDataRx() : Observable<Country>
}