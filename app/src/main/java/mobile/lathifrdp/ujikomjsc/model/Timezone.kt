import com.google.gson.annotations.SerializedName

class Timezone (
	@field:SerializedName("offset") var offset : String,
	@field:SerializedName("description") var description : String
)