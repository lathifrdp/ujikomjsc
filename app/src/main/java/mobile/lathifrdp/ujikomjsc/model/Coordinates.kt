import com.google.gson.annotations.SerializedName

class Coordinates (
	@field:SerializedName("latitude") val latitude : Double,
	@field:SerializedName("longitude") val longitude : Double
)