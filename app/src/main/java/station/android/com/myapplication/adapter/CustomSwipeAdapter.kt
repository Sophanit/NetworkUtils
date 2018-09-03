package station.android.com.myapplication.adapter

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import station.android.com.myapplication.R
import station.android.com.myapplication.model.Product

class CustomSwipeAdapter(private val products: ArrayList<Product>) : RecyclerSwipeAdapter<CustomSwipeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getSwipeLayoutResourceId(position: Int): Int {
        return R.id.swipe_layout
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = products[position]

        holder.delete.setOnClickListener {
            products.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

        holder.swipe.addSwipeListener(object : SwipeLayout.SwipeListener {
            override fun onOpen(layout: SwipeLayout?) {
                Log.d("tSwipeAct", "onOpen")
            }

            override fun onUpdate(layout: SwipeLayout?, leftOffset: Int, topOffset: Int) {
                Log.d("tSwipeAct", "onUpdate")
            }

            //Go First
            override fun onStartOpen(layout: SwipeLayout?) {
                Log.d("tSwipeAct", "onStartOpen")
                holder.llfont.setBackgroundColor(Color.WHITE)
                holder.delete.setBackgroundColor(Color.RED)
            }

            override fun onStartClose(layout: SwipeLayout?) {
                Log.d("tSwipeAct", "onStartClose")
            }

            override fun onHandRelease(layout: SwipeLayout?, xvel: Float, yvel: Float) {
                Log.d("tSwipeAct", "onHandRelease")
            }

            override fun onClose(layout: SwipeLayout?) {
                Log.d("tSwipeAct", "onClose")
                holder.llfont.setBackgroundColor(Color.TRANSPARENT)
                holder.delete.setBackgroundColor(Color.TRANSPARENT)
            }

        })
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val swipe = v.swipe_layout
        val delete = v.llDelete
        val llfont = v.llItemFont
        val context = v.context
    }

    fun removeAt(position: Int) {
        products.removeAt(position)
        notifyItemRemoved(position)
    }

}