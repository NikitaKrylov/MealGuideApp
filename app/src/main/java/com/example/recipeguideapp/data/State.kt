package com.example.recipeguideapp.data

import java.lang.Exception

data class State<out Data>(val status: Status, val data: Data?, val error: Exception?) {

    companion object{

        fun <Data>loading() = State<Data>(Status.LOADING, null, null)
        fun <Data>success(data: Data?) = State<Data>(Status.SUCCESS, data, null)
        fun <Data>error(error: Exception?) = State<Data>(Status.ERROR, null, error)

        enum class Status{
            SUCCESS,
            ERROR,
            LOADING
        }
    }
}