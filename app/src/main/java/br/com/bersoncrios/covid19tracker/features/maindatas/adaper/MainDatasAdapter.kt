package br.com.bersoncrios.covid19tracker.features.maindatas.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.bersoncrios.covid19tracker.R
import br.com.bersoncrios.covid19tracker.network.data.model.GlobalData


class MainDatasAdapter(val list: List<GlobalData>?) :
    RecyclerView.Adapter<MainDatasAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.main_data_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.country.text = list!![position].Country
        holder.totalConfirmed.text = list[position].TotalConfirmed.toString()
        holder.totalRecovered.text = list[position].TotalRecovered.toString()
        holder.totalDeaths.text = list[position].TotalDeaths.toString()

    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val country: TextView = item.findViewById(R.id.txtCountryName)
        val totalConfirmed: TextView = item.findViewById(R.id.txtConfirmCases)
        val totalRecovered: TextView = item.findViewById(R.id.txtRecovered)
        val totalDeaths: TextView = item.findViewById(R.id.txtTotalDeaths)
    }
}