package br.com.fiap.a31scj.crud

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_editar_jogo.*
import kotlinx.android.synthetic.main.jogo_layout.*

class EditarJogo: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_jogo)

        this.setDados()
    }

    private fun setDados () {
        val titulo = getIntent().getStringExtra("nome")
        val descricao = getIntent().getStringExtra("descricao")
        val id = getIntent().getStringExtra("id")

        this.nome.setText(titulo)
        this.descricao.setText(descricao)
    }
}
