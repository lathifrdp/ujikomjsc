import com.google.gson.annotations.SerializedName

class Name (
	@field:SerializedName("title") var title : String,
	@field:SerializedName("first") var first : String,
	@field:SerializedName("last") var last : String
)