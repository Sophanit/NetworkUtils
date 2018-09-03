package station.android.com.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daimajia.swipe.SwipeLayout
import station.android.com.myapplication.R
import station.android.com.myapplication.model.Product

class ProductRecyclerAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_product, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = products[position]
        holder.setData(item)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v), SwipeLayout.SwipeListener {
        override fun onOpen(layout: SwipeLayout?) {

        }

        override fun onUpdate(layout: SwipeLayout?, leftOffset: Int, topOffset: Int) {

        }

        override fun onStartOpen(layout: SwipeLayout?) {

        }

        override fun onStartClose(layout: SwipeLayout?) {

        }

        override fun onHandRelease(layout: SwipeLayout?, xvel: Float, yvel: Float) {

        }

        override fun onClose(layout: SwipeLayout?) {

        }

        fun setData(product: Product) {

        }
    }

}