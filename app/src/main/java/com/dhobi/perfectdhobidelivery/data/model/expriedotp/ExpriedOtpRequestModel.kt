package com.dhobi.perfectdhobidelivery.data.model.expriedotp

import com.google.gson.annotations.SerializedName

data class ExpriedOtpRequestModel(

    @SerializedName("phone")
    val phone: String
)