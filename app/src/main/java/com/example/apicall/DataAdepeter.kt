package com.example.apicall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DataAdepeter(body: List<PassmodelItem>?) : Adapter<DataAdepeter.Dataholder>() {

    lateinit var context:Context
    var list =body

    class Dataholder(itemView: View) : ViewHolder(itemView) {

        var txtid=itemView.findViewById<TextView>(R.id.customerid)
        var txtuserid=itemView.findViewById<TextView>(R.id.userid)
        var title=itemView.findViewById<TextView>(R.id.title)
        var body=itemView.findViewById<TextView>(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dataholder {
        context=parent.context
      return Dataholder(LayoutInflater.from(parent.context).inflate(R.layout.data_item,parent,false))
    }

    override fun getItemCount(): Int {
return list?.size!!
    }

    override fun onBindViewHolder(holder: Dataholder, position: Int) {
       holder.txtid.text=list?.get(position)?.id.toString()
        holder.txtuserid.text=list?.get(position)?.userId.toString()
        holder.title.text=list?.get(position)?.title.toString()
        holder.body.text=list?.get(position)?.body.toString()


    }
}