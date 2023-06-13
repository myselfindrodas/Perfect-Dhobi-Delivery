package com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginResponseModel


import com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginResponseModel.Data
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // OTP has been sent !
    @SerializedName("status")
    val status: Boolean // true
)