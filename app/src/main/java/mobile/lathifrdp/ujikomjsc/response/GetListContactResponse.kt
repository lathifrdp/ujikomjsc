package mobile.lathifrdp.ujikomjsc.response

import Contact
import com.google.gson.annotations.SerializedName

class GetListContactResponse (
    @field:SerializedName("results") var results : List<Contact>
)