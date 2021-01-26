import com.google.gson.annotations.SerializedName

class Dob (
	@field:SerializedName("date") var date : String,
	@field:SerializedName("age") var age : Int
)