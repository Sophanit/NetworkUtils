package station.android.com.myapplication.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo


class NetworkStateReceiver : BroadcastReceiver() {
    private var listeners: ArrayList<NetworkStateReceiverListener> = ArrayList()
    var connected: Boolean? = false

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent == null || intent.extras == null)
            return

        val manager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = manager.activeNetworkInfo

        if (ni != null && ni.state == NetworkInfo.State.CONNECTED) {
            connected = true
        } else if (intent.getBooleanExtra(
                        ConnectivityManager.EXTRA_NO_CONNECTIVITY, java.lang.Boolean.FALSE)) {
            connected = false
        }

        notifyStateToAll()
    }

    fun notifyStateToAll() {
        for (listener in listeners)
            notifyState(listener)
    }

    fun notifyState(listener: NetworkStateReceiverListener?) {
        if (connected == null || listener == null)
            return

        if (connected == true)
            listener.networkAvailable()
        else
            listener.networkUnavailable()
    }

    fun addListener(l: NetworkStateReceiverListener) {
        listeners.add(l)
        notifyState(l)
    }

    fun removeListener(l: NetworkStateReceiverListener) {
        listeners.remove(l)
    }

    interface NetworkStateReceiverListener {
        fun networkAvailable()

        fun networkUnavailable()
    }

}