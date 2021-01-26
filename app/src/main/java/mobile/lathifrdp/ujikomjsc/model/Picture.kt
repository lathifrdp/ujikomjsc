import com.google.gson.annotations.SerializedName

class Picture (
	@field:SerializedName("large") var large : String,
	@field:SerializedName("medium") var medium : String,
	@field:SerializedName("thumbnail") var thumbnail : String
)