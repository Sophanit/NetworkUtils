package station.android.com.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import station.android.com.myapplication.R
import station.android.com.myapplication.model.Product

class GeneralAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.items_layout, parent, false)
        return rootView as GeneralViewHolder
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        holder.setList(products[position])
    }

    class GeneralViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(view: View?) {

        }

        fun setList(product: Product) {

        }
    }
}