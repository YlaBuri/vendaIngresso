package br.com.ticketca.step

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ticketca.R
import br.com.ticketca.databinding.ItemTicketsSelectDateBinding
import br.com.ticketca.model.Ingresso
import br.com.ticketca.model.Ticket

class SelectDateAdapter(
    private val ingressos: List<Ingresso>
):
    RecyclerView.Adapter<SelectDateAdapter.SelectDateViewHolder>() {

    var onItemClickListener: (ticket: Ingresso) -> Unit = {}

    class SelectDateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.select_date_title)
        val value: TextView = itemView.findViewById(R.id.select_date_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectDateViewHolder {
        val binding = ItemTicketsSelectDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectDateViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SelectDateViewHolder, position: Int) {
        val ingresso = ingressos[position]
        holder.title.text = ingresso.referencia
        holder.value.text = ingresso.valorIngresso.toString()
    }

    override fun getItemCount(): Int {
        return ingressos.size
    }
}