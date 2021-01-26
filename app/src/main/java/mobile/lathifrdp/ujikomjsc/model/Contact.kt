import com.google.gson.annotations.SerializedName

class Contact (
	@field:SerializedName("gender") val gender : String,
	@field:SerializedName("name") val name : Name,
	@field:SerializedName("location") val location : Location,
	@field:SerializedName("email") val email : String,
	@field:SerializedName("dob") val dob : Dob,
	@field:SerializedName("phone") val phone : String,
	@field:SerializedName("cell") val cell : String,
	@field:SerializedName("picture") val picture : Picture
)