import com.google.gson.annotations.SerializedName

class Coordinates (
	@field:SerializedName("latitude") var latitude : Double,
	@field:SerializedName("longitude") var longitude : Double
)