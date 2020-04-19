package br.com.bersoncrios.covid19tracker.network.services

import br.com.bersoncrios.covid19tracker.network.data.Country
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {
    @GET("summary")
    fun fetchData(): Call<Country>
}