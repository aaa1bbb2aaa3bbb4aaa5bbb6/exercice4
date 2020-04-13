package com.example.td4exo4

class Seance {

    private val nom :String

    constructor(nom:String){

        this.nom="Votre Seance de :  "  + nom
    }

    fun getNom(): String {
        return this.nom
    }
}
