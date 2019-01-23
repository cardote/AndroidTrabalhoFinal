package Interfaces

import Models.Jogo
import retrofit2.Call
import retrofit2.http.GET

interface JogosHttp {
    @GET("/")
    fun buscarJogos(): Call<Array<Jogo>>
}