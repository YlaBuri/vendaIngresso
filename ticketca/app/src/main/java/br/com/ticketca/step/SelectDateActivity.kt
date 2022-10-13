package br.com.ticketca.step

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.ticketca.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectDateActivity : AppCompatActivity() {

    private val selectDateViewModel: SelectDateViewModel by viewModel()
    private lateinit var spinnerAdapter: SpinnerAdapter

    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")

    private val spinner: Spinner? by lazy {
        findViewById(R.id.activity_select_date_spinner)
    }

    private val title: TextView? by lazy {
        findViewById(R.id.activity_select_date_title)
    }

    private val tickets: MutableList<String> = mutableListOf()

    private val response: String? by lazy {
        intent.getStringExtra("ticket")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_date)
        title?.text = response

        selectDateViewModel.selectTicketDate.observe(this, {
            spinnerAdapter = SpinnerAdapter(it, this)
            spinner?.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, it)
        })
        selectDateViewModel.findSelectTicketDate()

//        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                tickets.add(spinner?.selectedItem.toString())
//                listView?.adapter = ArrayAdapter(
//                    this@SelectDateActivity,
//                    android.R.layout.simple_list_item_1,
//                    tickets
//                )
//
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//        }
//
//        listView?.onItemLongClickListener =
//            AdapterView.OnItemLongClickListener { p0, p1, p2, p3 ->
//                val escolhido = p0?.getItemAtPosition(p2)
//                tickets.remove(escolhido)
//            }
    }
}