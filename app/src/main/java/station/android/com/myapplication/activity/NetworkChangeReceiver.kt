package station.android.com.myapplication.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import station.android.com.myapplication.util.NetworkUtil


class NetworkChangeReceiver : BroadcastReceiver() {
    val TAG = "tMainActivity"
    val ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
    var listener: ConnectionReceiverListener? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        val status = NetworkUtil().getConnectivityStatus(context!!)
        if (ACTION == intent!!.action) {
            listener?.onNetworkConnectionChanged(status)
        }
    }

    interface ConnectionReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }
}