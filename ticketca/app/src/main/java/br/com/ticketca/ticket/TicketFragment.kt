package br.com.ticketca.ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ticketca.databinding.FragmentTicketBinding
import br.com.ticketca.model.Ticket
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketFragment : Fragment() {

    private val ticketViewModel: TicketViewModel by viewModel()
    private lateinit var adapter: TicketAdapter
    private lateinit var l: List<Ticket>
    private lateinit var binding: FragmentTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ticketViewModel.ticketViewModel.observe(viewLifecycleOwner, Observer {
            l = it
            configAdapter(it)
        })
        ticketViewModel.findTickets()
    }

    private fun configAdapter(it: List<Ticket>) {
        adapter = TicketAdapter(it)
        binding.fragmentTicketRecyclerView.adapter = adapter
        binding.fragmentTicketRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.onItemClickListener = { it ->
            val directions = TicketFragmentDirections.actionTicketFragmentToSelectDateFragment(it)
            findNavController().navigate(directions)
        }
    }
}