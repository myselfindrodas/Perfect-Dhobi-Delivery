package com.dhobi.perfectdhobidelivery.data.model.otpmodel.otpResponseModel


import com.dhobi.perfectdhobidelivery.data.model.otpmodel.otpResponseModel.Data
import com.google.gson.annotations.SerializedName

data class OtpResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // OTP Validated !
    @SerializedName("status")
    val status: Boolean // true
)