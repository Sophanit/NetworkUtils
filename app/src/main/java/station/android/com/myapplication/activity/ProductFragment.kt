package station.android.com.myapplication.activity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import station.android.com.myapplication.R

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_product, container, false)
        return rootView
    }


}
