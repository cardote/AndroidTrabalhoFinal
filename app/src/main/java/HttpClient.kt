import Interfaces.JogosHttp
import Models.Jogo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class HttpClient {

    companion object {
        fun getJogos() {
            val url: String = "https://android-server-app.herokuapp.com/"
            val retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            val service: JogosHttp = retrofit.create(JogosHttp::class.java)
                service.buscarJogos()
                .enqueue(object: Callback<Array<Jogo>> {
                    override fun onFailure(call: Call<Array<Jogo>>, t: Throwable) {
                        print("Deu ruim!")
                    }

                    override fun onResponse(call: Call<Array<Jogo>>, response: Response<Array<Jogo>>) {
                        print("Funcionou!")
                    }

                })
        }
    }
}