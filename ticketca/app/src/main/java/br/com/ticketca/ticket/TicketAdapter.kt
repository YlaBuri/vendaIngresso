package br.com.ticketca.ticket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ticketca.R
import br.com.ticketca.databinding.ItemTicketBinding
import br.com.ticketca.model.Ticket
import com.bumptech.glide.Glide

class TicketAdapter(
    private val tickets: List<Ticket>
): RecyclerView.Adapter<TicketAdapter.TickerViewHolder>() {

    var onItemClickListener: (ticket: Ticket) -> Unit = {}

    class TickerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_ticket_title)
        val image: ImageView = itemView.findViewById(R.id.item_ticket_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerViewHolder {
        val binding = ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TickerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TickerViewHolder, position: Int) {
        val tickets = tickets[position]
        holder.title.text = tickets.titulo
        Glide.with(holder.itemView.context).load(tickets.imagem).into(holder.image)
        holder.itemView.setOnClickListener {
            onItemClickListener(tickets)
        }
    }

    override fun getItemCount(): Int {
        return tickets.size
    }
}