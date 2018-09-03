package station.android.com.myapplication.activity

import android.app.Application


class MyApplication : Application() {

    companion object {

        private var shared: MyApplication? = null
        private var listener: NetworkChangeReceiver.ConnectionReceiverListener? = null

        fun newInstance(): MyApplication {
            if (shared == null) {
                shared = MyApplication()
            }
            return shared!!
        }

        fun setListener(listener: NetworkChangeReceiver.ConnectionReceiverListener) {
            this.listener = listener
        }
    }
}