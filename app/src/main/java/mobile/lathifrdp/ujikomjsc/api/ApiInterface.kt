package mobile.lathifrdp.ujikomjsc.api

import mobile.lathifrdp.ujikomjsc.response.GetListContactResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("api")
    abstract fun getContact(
        @Query("results") results: Int?,
        @Query("exc") exc: String,
        @Query("nat") nat: String,
        @Query("noinfo") noinfo: String
    ): Call<GetListContactResponse>
}