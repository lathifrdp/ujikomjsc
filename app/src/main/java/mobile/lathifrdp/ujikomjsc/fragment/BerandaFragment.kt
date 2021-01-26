package mobile.lathifrdp.ujikomjsc.fragment

import Contact
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import mobile.lathifrdp.ujikomjsc.R
import mobile.lathifrdp.ujikomjsc.adapter.ContactList
import mobile.lathifrdp.ujikomjsc.api.ApiClient
import mobile.lathifrdp.ujikomjsc.api.ApiInterface
import mobile.lathifrdp.ujikomjsc.response.GetListContactResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BerandaFragment : Fragment() {
    internal lateinit var apiService: ApiInterface
    internal var bundle: Bundle? = null
    internal lateinit var listViewKontak: ListView
    internal lateinit var adapterKontak: ContactList
    private var listKontak: List<Contact>? = null
    private var isRefresh = false
    lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mSwipeRefreshLayout = getView()!!.findViewById(R.id.swipeToRefresh) as SwipeRefreshLayout
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)

        val activity = requireActivity()
        listViewKontak = getView()!!.findViewById(R.id.listKontak) as ListView
        listKontak = ArrayList<Contact>()
        adapterKontak = ContactList(listKontak as ArrayList<Contact>, activity)
        listViewKontak.adapter = adapterKontak

        loadKontak(activity)

        mSwipeRefreshLayout.setOnRefreshListener {
            var newFragment: Fragment? = null
            newFragment = BerandaFragment()

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.screen_area, newFragment as BerandaFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun loadKontak(_context: Context) {
        apiService = ApiClient.client.create(ApiInterface::class.java)

        val call = apiService.getContact(5, "login,registered,id,nat", "us", "")
        call.enqueue(object : Callback<GetListContactResponse> {
            override fun onResponse(call: Call<GetListContactResponse>, response: Response<GetListContactResponse>) {
                if (response.isSuccessful()) {
                    val res = response.body()
                    if (isRefresh) {
                        adapterKontak.setList(res.results as MutableList<Contact>)
                    } else {
                        adapterKontak.addList(res.results as MutableList<Contact>)
                    }

                    isRefresh = false
                    adapterKontak.notifyDataSetChanged()
                } else {
                    Toast.makeText(_context, "Sedang terjadi kesalahan", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<GetListContactResponse>, t: Throwable) {
                Toast.makeText(_context, "Data gagal dimuat", Toast.LENGTH_SHORT).show()
            }
        })
    }
}