package mobile.lathifrdp.ujikomjsc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val URL = "https://randomuser.me/"

    var RETROFIT: Retrofit? = null
    val client: Retrofit
        get() {
            if (RETROFIT == null) {
                RETROFIT = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return this!!.RETROFIT!!
        }
}