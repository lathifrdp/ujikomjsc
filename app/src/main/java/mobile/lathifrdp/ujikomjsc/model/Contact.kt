import com.google.gson.annotations.SerializedName

class Contact (
	@field:SerializedName("gender") var gender : String,
	@field:SerializedName("name") var name : Name,
	@field:SerializedName("location") var location : Location,
	@field:SerializedName("email") var email : String,
	@field:SerializedName("dob") var dob : Dob,
	@field:SerializedName("phone") var phone : String,
	@field:SerializedName("cell") var cell : String,
	@field:SerializedName("picture") var picture : Picture
)