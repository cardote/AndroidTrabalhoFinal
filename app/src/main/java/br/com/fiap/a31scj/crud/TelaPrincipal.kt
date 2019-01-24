package br.com.fiap.a31scj.crud

import Config.RetrofitInit
import Models.Jogo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_principal.*
import JogosAdapter
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val context = this
        val call = RetrofitInit().jogoService().lista()
        call.enqueue(object: Callback<List<Jogo>> {
            override fun onFailure(call: Call<List<Jogo>>, t: Throwable) {
                // print(t)
            }

            override fun onResponse(call: Call<List<Jogo>>, response: Response<List<Jogo>>) {
                response?.body()?.let {
                    val jogos: List<Jogo> = it
                    val recycleView = jogo_recyclerview
                    recycleView.adapter = JogosAdapter(jogos, context)

                    val layoutManager = GridLayoutManager(context, 1)
                    recycleView.layoutManager = layoutManager as RecyclerView.LayoutManager?
                }
            }

        })

        fab.setOnClickListener{
            val intent = Intent(this, NovoJogo::class.java);
            startActivity(intent);
        }
    }

    private fun jogos(): List<Jogo> {


        return listOf(
                Jogo("Street Fighter II", "Da cabeçada!!!", "1"),
                Jogo("Megaman X", "Dando tiro pra todo lado", "2"),
                Jogo("Mortal Kombat III", "Clássico Foda", "3")
        )
    }
}
