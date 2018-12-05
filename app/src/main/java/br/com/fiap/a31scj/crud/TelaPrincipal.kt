package br.com.fiap.a31scj.crud

import Models.Jogo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_principal.*
import JogosAdapter
import android.support.v7.widget.StaggeredGridLayoutManager

class TelaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val recycleView = jogo_recyclerview
        recycleView.adapter = JogosAdapter(jogos(), this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        recycleView.layoutManager = layoutManager
    }

    private fun jogos(): List<Jogo> {
        return listOf(
                Jogo("Street Fighter II", "Da cabeçada!!!"),
                Jogo("Megaman X", "Dando tiro pra todo lado"),
                Jogo("Mortal Kombat III", "Clássico Foda")
        )
    }
}
