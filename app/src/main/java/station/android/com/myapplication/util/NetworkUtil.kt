package station.android.com.myapplication.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {
    val TYPE_WIFI = 1
    val TYPE_MOBILE = 2
    val TYPE_NOT_CONNECTED = 0

    fun getConnectivityType(context: Context): Int {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI

            if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE
        }
        return TYPE_NOT_CONNECTED
    }

    fun getConnectivityStatus(context: Context): Boolean {
        val conn = NetworkUtil().getConnectivityType(context)
        var status: Boolean? = false
        when (conn) {
            NetworkUtil().TYPE_WIFI -> status = true
            NetworkUtil().TYPE_MOBILE -> status = true
            NetworkUtil().TYPE_NOT_CONNECTED -> status = false
        }
        return status!!
    }
}