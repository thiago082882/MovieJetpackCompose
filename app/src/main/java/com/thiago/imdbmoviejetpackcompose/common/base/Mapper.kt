package com.thiago.imdbmoviejetpackcompose.common.base

interface Mapper<F,T> {

    fun fromMap(from:F):T

}