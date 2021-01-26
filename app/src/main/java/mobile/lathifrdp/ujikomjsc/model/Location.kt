import com.google.gson.annotations.SerializedName

class Location (
	@field:SerializedName("street") val street : Street,
	@field:SerializedName("city") val city : String,
	@field:SerializedName("state") val state : String,
	@field:SerializedName("country") val country : String,
	@field:SerializedName("postcode") val postcode : Int,
	@field:SerializedName("coordinates") val coordinates : Coordinates,
	@field:SerializedName("timezone") val timezone : Timezone
)