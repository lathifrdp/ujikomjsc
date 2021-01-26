package mobile.lathifrdp.ujikomjsc.adapter

import Contact
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import mobile.lathifrdp.ujikomjsc.R
import mobile.lathifrdp.ujikomjsc.response.GetListContactResponse

class ContactList(private var dataSet: MutableList<Contact>?, internal var mContext: Context) : ArrayAdapter<Contact>(mContext, R.layout.row_item_contact,
    dataSet as MutableList<Contact>
), View.OnClickListener {
    val size: Int
        get() {
            if (dataSet == null) dataSet = ArrayList<Contact>()
            return dataSet!!.size
        }

    private var lastPosition = -1

    fun setList(list: MutableList<Contact>) {
        if (dataSet == null) dataSet = ArrayList<Contact>()
        this.dataSet = list
    }

    fun addList(list: MutableList<Contact>) {
        if (dataSet == null) dataSet = ArrayList<Contact>()
        this.dataSet!!.addAll(list)
    }

    // View lookup cache
    private class ViewHolder {
        internal var nama_kontak: TextView? = null
        internal var foto_kontak: ImageView? = null
    }

    override fun onClick(v: View) {

        val position = v.tag as Int
        val `object` = getItem(position)
        val dataModel = `object` as Contact
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Get the data item for this position
        val dataModel = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder // view lookup cache stored in tag

        val result: View

        if (convertView == null) {

            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.row_item_contact, parent, false)
            viewHolder.nama_kontak = convertView!!.findViewById(R.id.nama_kontak) as TextView
            viewHolder.foto_kontak = convertView.findViewById(R.id.foto_kontak) as ImageView

            result = convertView

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }

        viewHolder.nama_kontak!!.setText(dataModel!!.name.title + " " + dataModel!!.name.first + " " + dataModel!!.name.last)
        var pathnya: String? = null
        var gambarnya = dataModel.picture.thumbnail
        if (gambarnya == "") {
            pathnya = "kosong"
        } else {
            pathnya = gambarnya
        }

        Picasso.get()
            .load(pathnya)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(viewHolder.foto_kontak)
        // Return the completed view to render on screen
        return convertView
    }
}