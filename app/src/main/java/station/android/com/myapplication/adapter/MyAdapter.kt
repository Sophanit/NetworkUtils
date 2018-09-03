package station.android.com.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import station.android.com.myapplication.R
import station.android.com.myapplication.model.Product

class MyAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.VH>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VH {
        return VH(p0)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(p0: VH, p1: Int) {
        p0.bind(products[p1])
    }

    fun removeAt(position: Int) {
        products.removeAt(position)
        notifyItemRemoved(position)
    }

    class VH(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)) {
        fun bind(product: Product) = with(itemView) {

        }
    }
}