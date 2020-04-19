package br.com.bersoncrios.covid19tracker.network.data.model

data class GlobalData(
    var Country: String,
    var NewConfirmed: Int,
    var TotalConfirmed: Int,
    var NewDeaths: Int,
    var TotalDeaths: Int,
    var NewRecovered: Int,
    var TotalRecovered: Int
)