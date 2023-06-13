package com.dhobi.perfectdhobidelivery.data.model

import com.google.gson.annotations.SerializedName

class CommonResponseModel(
    @SerializedName("status")
    val status: Int,
    @SerializedName("msg")
    val message: String
) {
}