package station.android.com.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_another.*
import station.android.com.myapplication.R
import station.android.com.myapplication.model.Customer
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL


class AnotherActivity : AppCompatActivity() {

    val TAG = "tMainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        var customers: ArrayList<Customer> = ArrayList()
        for (customer in 1 until 20) {
            customers.add(Customer())
        }

        val adapter = CustomerAdapter(customers)

        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
        rvCustomer.addItemDecoration(decoration)

        rvCustomer.layoutManager = LinearLayoutManager(this)
        rvCustomer.setHasFixedSize(true)
        rvCustomer.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    class CustomerAdapter(private val customers: ArrayList<Customer>) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.items_layout, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = customers.size

        override
        fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            var context = v.context
        }
    }
}
