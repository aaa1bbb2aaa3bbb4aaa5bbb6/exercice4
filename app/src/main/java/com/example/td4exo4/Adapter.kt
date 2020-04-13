package com.example.td4exo4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class Adapter(
    // Declare Variables

    internal var mContext: Context
) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Seance>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(Liste.moviesList)
    }

    inner class ViewHolder {

        internal var text: TextView? = null

    }

    override fun getCount(): Int {
        return Liste.moviesList.size
    }

    override fun getItem(position: Int):Seance {
        return Liste.moviesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.seance, null)
            holder.text = view!!.findViewById(R.id.text) as TextView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

          holder.text!!.setText(Liste.moviesList[position].getNom())
        return view
    }



}