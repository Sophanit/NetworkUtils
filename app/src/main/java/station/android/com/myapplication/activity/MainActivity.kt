package station.android.com.myapplication.activity

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*
import station.android.com.myapplication.R
import station.android.com.myapplication.adapter.CustomSwipeAdapter
import station.android.com.myapplication.adapter.MyAdapter
import station.android.com.myapplication.adapter.MyCutomAdapter
import station.android.com.myapplication.adapter.SwipeToDeleteCallback
import station.android.com.myapplication.dialog.CustomAlertDialog
import station.android.com.myapplication.model.Product
import station.android.com.myapplication.reciever.NetworkStateReceiver
import station.android.com.myapplication.swipe.SwipeController


class MainActivity : AppCompatActivity(), NetworkStateReceiver.NetworkStateReceiverListener {

    val TAG = "tMainActivity"
    var dialog: CustomAlertDialog? = null
    var isConnected: Boolean = false
    var networkStateReceiver: NetworkStateReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        dialog = CustomAlertDialog.getInstance(supportFragmentManager)

        btnShow.setOnClickListener {
            startActivity(Intent(this, AnotherActivity::class.java))
        }

        registerNetworkState()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterNetworkState()
    }

    fun registerNetworkState() {

        if (networkStateReceiver == null) {
            networkStateReceiver = NetworkStateReceiver()
            networkStateReceiver!!.addListener(this)
        }

        this.registerReceiver(networkStateReceiver, IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION))
    }

    fun unRegisterNetworkState() {

        try {
            this.unregisterReceiver(networkStateReceiver)
        } catch (ex: Exception) {

        }
    }

    override fun networkAvailable() {
        isConnected = true
        closeNoInternetDialog()
    }

    override fun networkUnavailable() {
        isConnected = false
        openNoInternetDialog()
    }


    fun openNoInternetDialog() {

        dialog?.let {
            if (!dialog!!.isDisplay) {
                dialog!!.show()
            }
        }
    }


    fun closeNoInternetDialog() {

        dialog?.let {
            if (dialog!!.isDisplay) {
                dialog!!.hide()
            }
        }
    }

    fun setupMyCustomAdapter() {
        var products: ArrayList<Product> = ArrayList()
        for (index in 0 until 15) {
            products.add(Product())
        }
        var manager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, manager.orientation)
        rvProduct.addItemDecoration(dividerItemDecoration)

        rvProduct.layoutManager = manager
        val adapter = MyCutomAdapter(products)
        rvProduct.adapter = adapter
        val swipeController = SwipeController()
        val itemTouchHelper = ItemTouchHelper(swipeController)
        itemTouchHelper.attachToRecyclerView(rvProduct)
        adapter.notifyDataSetChanged()
    }

    fun setMyAdapter() {
        var products: ArrayList<Product> = ArrayList()
        for (index in 1 until 15) {
            products.add(Product())
        }
        var manager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, manager.orientation)
        rvProduct.addItemDecoration(dividerItemDecoration)

        rvProduct.layoutManager = manager
        val adapter = MyAdapter(products)
        rvProduct.adapter = adapter
        adapter.notifyDataSetChanged()

        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rvProduct.adapter as MyAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvProduct)
    }

    fun setupRecycler() {
        var products: ArrayList<Product> = ArrayList()
        for (index in 1 until 10) {
            products.add(Product())
        }
        var manager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, manager.orientation)
//        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.sk_line_divider)!!)
        rvProduct.addItemDecoration(dividerItemDecoration)

        rvProduct.layoutManager = manager
        val adapter = CustomSwipeAdapter(products)
        rvProduct.adapter = adapter
        adapter.notifyDataSetChanged()
    }

//    fun setupViewPager() {
//        val fragments: ArrayList<ProductFragment> = ArrayList()
//        val products: ArrayList<Product> = ArrayList()
//        for (index in 0 until 5) {
//            products.add(Product())
//        }
//
//        for (index in 0 until products.size) {
//            fragments.add(ProductFragment())
//        }
//
//        tlDots.setupWithViewPager(vpProduct, true)
//        vpProduct.clipToPadding = false
//        vpProduct.pageMargin = dpToPx(13)
//        vpProduct.adapter = ProductAdapter(supportFragmentManager, fragments)
//    }

    fun dpToPx(dp: Int): Int {
        val displayMetrics = this.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}
