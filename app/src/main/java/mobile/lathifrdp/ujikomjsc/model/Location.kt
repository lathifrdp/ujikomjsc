import com.google.gson.annotations.SerializedName

class Location (
	@field:SerializedName("street") var street : Street,
	@field:SerializedName("city") var city : String,
	@field:SerializedName("state") var state : String,
	@field:SerializedName("country") var country : String,
	@field:SerializedName("postcode") var postcode : Int,
	@field:SerializedName("coordinates") var coordinates : Coordinates,
	@field:SerializedName("timezone") var timezone : Timezone
)