package com.dhobi.perfectdhobidelivery.data.model.RatechartModel


import com.dhobi.perfectdhobidelivery.data.model.RatechartModel.Data
import com.google.gson.annotations.SerializedName

data class RatechartResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // Data available!
    @SerializedName("status")
    val status: Boolean // true
)