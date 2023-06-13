package com.dhobi.perfectdhobidelivery.data.model.logoutmodel.LogoutResponseModel


import com.dhobi.perfectdhobidelivery.data.model.logoutmodel.LogoutResponseModel.Data
import com.google.gson.annotations.SerializedName

data class LogoutResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // Logged Out successfully !
    @SerializedName("status")
    val status: Boolean // true
)