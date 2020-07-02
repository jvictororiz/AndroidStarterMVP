package br.com.jvictororiz.startermvp.data.service

import br.com.jvictororiz.startermvp.data.entities.User
import retrofit2.Call
import retrofit2.http.GET


interface PicPayService {

    @GET("users")
    fun getUsers(): Call<List<User>>
}