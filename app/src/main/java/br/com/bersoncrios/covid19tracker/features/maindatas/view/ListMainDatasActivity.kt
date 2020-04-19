package br.com.bersoncrios.covid19tracker.features.maindatas.view

import android.os.Bundle
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
import kotlinx.android.synthetic.main.activity_main.*

class ListMainDatasActivity : AppCompatActivity() {

    var mProgressBar: ProgressBar? = null
    private lateinit var viewModel: MainDatasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel = ViewModelProviders.of(this).get(MainDatasViewModel::class.java)
        mProgressBar = progressBar
        progressBar.visibility = View.VISIBLE

        getListCasesToCountry()
    }

    private fun getListCasesToCountry() {
        val data = Observer<Country> {
            recyclerview.adapter = MainDatasAdapter(it.Countries)
            progressBar.visibility = View.GONE
        }
        viewModel.callAPI(this).observe(this, data)
    }
}
