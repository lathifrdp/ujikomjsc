import com.google.gson.annotations.SerializedName

class Name (
	@field:SerializedName("title") val title : String,
	@field:SerializedName("first") val first : String,
	@field:SerializedName("last") val last : String
)