package com.guy.android.pokemonlibrary.extensions

/**
 * Created by Guy on 6/5/2019.
 */

val String.numVowels: Int
    get() = count {
        "aeiou".contains(it)
    }

fun String.addGuy(): String {
    return this + "Guy"
}