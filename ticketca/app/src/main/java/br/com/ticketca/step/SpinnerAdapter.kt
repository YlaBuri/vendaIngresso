package br.com.ticketca.step

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.ticketca.R
import br.com.ticketca.model.Ingresso

class SpinnerAdapter(
    private val ticketList: List<Ingresso>,
    private val context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        return ticketList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, view: View, viewGroup: ViewGroup?): View {
        val viewRoot: View = LayoutInflater.from(context).inflate(R.layout.item_spinner, viewGroup, false)

        val title: TextView = view.findViewById(R.id.spinner_title)
        val value: TextView = view.findViewById(R.id.spinner_value)

        val ticketLists = ticketList[position]

        Log.i("AAAAA", ticketLists.toString())

        title.text = ticketLists.referencia
        value.text = ticketLists.valorIngresso.toString()

        return viewRoot
    }
}