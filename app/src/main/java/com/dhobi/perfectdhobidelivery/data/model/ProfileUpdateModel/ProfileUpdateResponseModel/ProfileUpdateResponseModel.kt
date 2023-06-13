package com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateResponseModel


import com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateResponseModel.Data
import com.google.gson.annotations.SerializedName

data class ProfileUpdateResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // Profile Updated Successfully!
    @SerializedName("status")
    val status: Boolean // true
)