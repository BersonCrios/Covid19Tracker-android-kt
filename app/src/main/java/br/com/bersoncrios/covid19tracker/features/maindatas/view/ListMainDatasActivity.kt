package br.com.bersoncrios.covid19tracker.features.maindatas.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.bersoncrios.covid19tracker.R
import br.com.bersoncrios.covid19tracker.features.maindatas.viewmodel.MainDatasViewModel
import br.com.bersoncrios.covid19tracker.network.data.model.Country
import br.com.bersoncrios.covid19tracker.features.maindatas.adaper.MainDatasAdapter
import br.com.bersoncrios.covid19tracker.network.data.model.GlobalData
import br.com.bersoncrios.covid19tracker.network.services.CovidService
import br.com.bersoncrios.covid19tracker.network.services.RetrofitApiService
import br.com.bersoncrios.covid19tracker.repositories.MainDatasRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class ListMainDatasActivity : AppCompatActivity() {

    var mProgressBar: ProgressBar? = null
    private lateinit var viewModel: MainDatasViewModel

    var datas: List<GlobalData> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
        viewModel = ViewModelProviders.of(this).get(MainDatasViewModel::class.java)
        mProgressBar = progressBar
        progressBar.visibility = View.VISIBLE

        getListCasesToCountry()
//        getListCasesToCountryRX()
    }

    private fun getListCasesToCountryRX() {
        MainDatasRepository().listMainDatas(this)!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                Log.e("aaaaaaaaaaa", it.toString())
            }, { e ->
                e.printStackTrace()
            },{
            })
    }


    private fun getListCasesToCountry() {
        val data = Observer<Country> {
            recyclerview.adapter = MainDatasAdapter(it.Countries)
            progressBar.visibility = View.GONE
        }
        viewModel.callAPI(this).observe(this, data)
    }
}
