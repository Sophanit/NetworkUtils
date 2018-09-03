package station.android.com.myapplication.adapter

import station.android.com.myapplication.R

enum class ProductPagerEnum {
    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_blue),
    ORANGE(R.string.orange, R.layout.view_green);

    private var mTitleResId: Int = 0
    private var mLayoutResId: Int = 0

    constructor(mTitleResId: Int, mLayoutResId: Int) {
        this.mTitleResId = mTitleResId
        this.mLayoutResId = mLayoutResId
    }

    fun getTitleId():Int{
        return mTitleResId
    }

    fun getResId():Int{
        return mLayoutResId
    }
}