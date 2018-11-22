import Models.Jogo
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class JogosAdapter(private val jogos: List<Jogo>) : Adapter<JogosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View) : RecycleView.ViewHolder(itemView) {

    }
}
