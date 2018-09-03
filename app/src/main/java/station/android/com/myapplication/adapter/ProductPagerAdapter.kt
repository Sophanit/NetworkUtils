package station.android.com.myapplication.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProductPagerAdapter : PagerAdapter {
    var context: Context? = null

    constructor(context: Context) {
        this.context = context
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val productPagerEnum = ProductPagerEnum.values()[position]
        val inflater = LayoutInflater.from(container.context)
        val layout = inflater.inflate(productPagerEnum.getResId(), container, false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun isViewFromObject(v: View, p1: Any): Boolean {
        return v == p1
    }

    override fun getCount(): Int {
        return ProductPagerEnum.values().size
    }
}