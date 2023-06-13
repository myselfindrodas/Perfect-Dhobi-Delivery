package com.dhobi.perfectdhobidelivery.data.model.notificationmodel


import com.dhobi.perfectdhobidelivery.data.model.notificationmodel.Data
import com.google.gson.annotations.SerializedName

data class NotificationResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errors")
    val errors: Any?, // null
    @SerializedName("message")
    val message: String, // Data available!
    @SerializedName("status")
    val status: Boolean // true
)