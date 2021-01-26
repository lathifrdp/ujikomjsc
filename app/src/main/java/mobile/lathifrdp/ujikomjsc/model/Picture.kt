import com.google.gson.annotations.SerializedName

class Picture (
	@field:SerializedName("large") val large : String,
	@field:SerializedName("medium") val medium : String,
	@field:SerializedName("thumbnail") val thumbnail : String
)