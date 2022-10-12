package br.com.ticketca.step

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.navArgs
import br.com.ticketca.R
import br.com.ticketca.databinding.FragmentSelectDateBinding
import br.com.ticketca.model.Ticket

class SelectDateFragment : Fragment() {

    private val args by navArgs<SelectDateFragmentArgs>()
    private lateinit var ticket: Ticket
    private lateinit var binding: FragmentSelectDateBinding
    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")

    private val spinner: Spinner? by lazy {
        view?.findViewById(R.id.fragment_select_date_spinner)
    }

    private val tickets: MutableList<String> = mutableListOf()

    private val listView: ListView? by lazy {
        view?.findViewById(R.id.fragment_list)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            ticket = args.ticket
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.ticket = ticket
        spinner?.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)

        spinner?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tickets.add(spinner?.selectedItem.toString())
                listView?.adapter =
                    ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, tickets)

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        listView?.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { p0, p1, p2, p3 ->
                val escolhido = p0?.getItemAtPosition(p2)
                tickets.remove(escolhido)
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectDateBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}