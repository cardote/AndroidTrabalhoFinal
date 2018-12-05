import Models.Jogo
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.a31scj.crud.R
import kotlinx.android.synthetic.main.jogo_layout.view.*

class JogosAdapter(
        private val jogos: List<Jogo>,
        private val context: Context) : Adapter<JogosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jogo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jogo = jogos[position]

        holder.let {
            it.bindview(jogo)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindview(jogo: Jogo) {
            val title = itemView.jogo_title
            val descricao = itemView.jogo_descricao

            title.text = jogo.titulo
            descricao.text = jogo.descricao
        }
    }
}