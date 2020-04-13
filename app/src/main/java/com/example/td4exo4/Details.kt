package com.example.td4exo4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class Details  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(R.layout.details, container, false)
        val bundle = this.arguments
        val image = rootView.findViewById<ImageView>(R.id.image)
        val intitule = rootView.findViewById<TextView>(R.id.description)
        val enseignant=rootView.findViewById<TextView>(R.id.auteur)
        val duree=rootView.findViewById<TextView>(R.id.pays)
        val module=rootView.findViewById<TextView>(R.id.genre)


        if (bundle != null) {
            val index = bundle.getInt("amount", android.R.attr.defaultValue)
            enseignant.text=resources.getStringArray(R.array.enseignant_array)[index]
            duree.text=resources.getStringArray(R.array.duree_array)[index]
            intitule.text=resources.getStringArray(R.array.intitule_array)[index]
            module.text=resources.getStringArray(R.array.module_array)[index]


            var images = resources.obtainTypedArray(R.array.images)
            var i= resources.getIntArray(R.array.images)[index]
            image.setImageResource(images.getResourceId(index,-1))
        }
        val click_me = rootView.findViewById(R.id.auteur) as TextView
        click_me.setOnClickListener {


            val fragment = Enseignant()
            val fragmentManager = activity!!.supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.contaner, fragment)
            fragment.arguments=bundle
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Détails"
    }
}
