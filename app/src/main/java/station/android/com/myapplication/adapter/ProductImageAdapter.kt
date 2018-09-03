package station.android.com.myapplication.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import station.android.com.myapplication.R

class ProductImageAdapter(private val mContext: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(200, 200)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(5, 5, 5, 5)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mThumbIds[position])
        return imageView
    }

    override fun getCount(): Int = mThumbIds.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    private val mThumbIds = arrayOf(
            R.drawable.ic_advice, R.drawable.ic_brainstorming,
            R.drawable.ic_collaboration, R.drawable.ic_communication,
            R.drawable.ic_feedback, R.drawable.ic_heart,
            R.drawable.ic_startup, R.drawable.ic_team_leader)
}