package com.example.td4exo4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import java.util.ArrayList

class Liste : Fragment()  {
    private var adapter: Adapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.liste, container, false)

        var array = arrayOf( Seance("Développement Mobile"),Seance("Développement Web"),Seance("Data Science"))

        val liste = rootView.findViewById(R.id.books) as ListView
        moviesList = ArrayList()


        for (i in array!!.indices) {
            val movieNames = array!![i]

            moviesList.add(  movieNames)
        }

        adapter = Adapter(activity!!)
        liste.adapter = adapter

        liste.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {

                // value of item that is clicked
                val bundle = Bundle()
                bundle.putInt("amount", position)

                val fragment = Details()
                val fragmentManager = activity!!.supportFragmentManager

                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.contaner, fragment)
                fragment.arguments=bundle
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()


            }
        }

        return rootView
    }
    companion object {
        var moviesList = ArrayList<Seance>()
    }

}
