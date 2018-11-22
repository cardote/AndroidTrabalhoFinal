import Models.Jogo
import android.content.Context
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.a31scj.crud.R

class JogosAdapter(private val jogos: List<Jogo>,
                   private val context: Context) : Adapter<JogosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jogo_layout, parent, false)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jogo = jogos[position]
        holder.title.text = jogo.title
        holder.description.text = jogo.description
    }

    class ViewHolder(itemView: View) : RecycleView.ViewHolder(itemView) {
        val title = itemView.note_item_title
        val description = itemView.note_item_description
    }
}
