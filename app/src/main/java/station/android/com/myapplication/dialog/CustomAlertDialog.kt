package station.android.com.myapplication.dialog

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*
import station.android.com.myapplication.R

class CustomAlertDialog : DialogFragment() {
    var isDisplay = false
    lateinit var rootView: View

    companion object {
        var instance: CustomAlertDialog? = null
        var fm: FragmentManager? = null

        fun getInstance(fm: FragmentManager): CustomAlertDialog {
            this.fm = fm
            instance = CustomAlertDialog()
            return instance!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.custom_alert_dialog, container, false)
//        dialog.window.setBackgroundDrawableResource(R.color.colorClear)
//        dialog.setCanceledOnTouchOutside(true)
        initEvent()
        return rootView
    }

    fun initEvent() {
        rootView.btnOpenWifiSettings.setOnClickListener(onClicked)
        rootView.btnClose.setOnClickListener(onClicked)
    }

    private var onClicked = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnClose -> hide()
            R.id.btnOpenWifiSettings -> startActivity(Intent(WifiManager.ACTION_PICK_WIFI_NETWORK))
        }
        hide()
    }

    fun show() {
        isDisplay = true
        show(fm, "CustomFragment")
    }

    fun hide() {
        dismiss()
        isDisplay = false
    }
}