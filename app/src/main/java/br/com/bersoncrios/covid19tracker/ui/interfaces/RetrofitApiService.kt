package br.com.bersoncrios.covid19tracker.ui.interfaces

import br.com.bersoncrios.covid19tracker.network.services.CovidService
import br.com.bersoncrios.covid19tracker.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiService {
    private val  retrofit = Retrofit.Builder()
        .baseUrl(Constants.URL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun covidService (): CovidService = retrofit.create(CovidService::class.java)
}