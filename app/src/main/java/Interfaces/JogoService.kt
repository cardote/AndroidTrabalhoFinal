package Interfaces

import Models.Jogo
import retrofit2.Call
import retrofit2.http.GET

interface JogoService {
    @GET("/")
    fun lista(): Call<List<Jogo>>
}