import com.google.gson.annotations.SerializedName

class Street (
	@field:SerializedName("number") val number : Int,
	@field:SerializedName("name") val name : String
)