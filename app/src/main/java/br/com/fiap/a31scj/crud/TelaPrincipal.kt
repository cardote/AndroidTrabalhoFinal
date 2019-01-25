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
import android.view.View
import android.widget.ProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaPrincipal : AppCompatActivity() {

    final private lateinit var progress: ProgressBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        this.progress = findViewById<ProgressBar>(R.id.progressBar)
        this.progress.visibility = View.VISIBLE

        val context = this
        val loader = this.progress
        val call = RetrofitInit().jogoService().lista()
        call.enqueue(object: Callback<List<Jogo>> {
            override fun onFailure(call: Call<List<Jogo>>, t: Throwable) {
                Snackbar.make(findViewById(android.R.id.content), "Houve um erro ao carregar a lista de jogos!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }

            override fun onResponse(call: Call<List<Jogo>>, response: Response<List<Jogo>>) {
                response?.body()?.let {
                    val jogos: List<Jogo> = it
                    val recycleView = jogo_recyclerview
                    recycleView.adapter = JogosAdapter(jogos, context)

                    val layoutManager = GridLayoutManager(context, 1)
                    recycleView.layoutManager = layoutManager as RecyclerView.LayoutManager?

                    loader.visibility = View.GONE
                }
            }

        })

        fab.setOnClickListener{
            val intent = Intent(this, NovoJogo::class.java);
            startActivity(intent);
        }
    }
}
