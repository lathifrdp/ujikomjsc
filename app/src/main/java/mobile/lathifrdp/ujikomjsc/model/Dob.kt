import com.google.gson.annotations.SerializedName

class Dob (
	@field:SerializedName("date") val date : String,
	@field:SerializedName("age") val age : Int
)