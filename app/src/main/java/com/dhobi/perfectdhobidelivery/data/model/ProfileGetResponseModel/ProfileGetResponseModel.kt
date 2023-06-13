package com.dhobi.perfectdhobidelivery.data.model.ProfileGetResponseModel


import com.dhobi.perfectdhobidelivery.data.model.ProfileGetResponseModel.Data
import com.google.gson.annotations.SerializedName

data class ProfileGetResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // Data available !
    @SerializedName("status")
    val status: Boolean // true
)