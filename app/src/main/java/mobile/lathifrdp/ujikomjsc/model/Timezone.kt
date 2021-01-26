import com.google.gson.annotations.SerializedName

class Timezone (
	@field:SerializedName("offset") val offset : String,
	@field:SerializedName("description") val description : String
)