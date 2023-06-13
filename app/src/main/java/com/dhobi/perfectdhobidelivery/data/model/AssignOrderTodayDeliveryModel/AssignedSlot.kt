package com.dhobi.perfectdhobidelivery.data.model.AssignOrderTodayDeliveryModel


import com.google.gson.annotations.SerializedName

data class AssignedSlot(
    @SerializedName("customerName")
    val customerName: String, // Test test1
    @SerializedName("deliveryDate")
    val deliveryDate: String, // 19-05-2023
    @SerializedName("deliveryTime")
    val deliveryTime: String, // 11:02AM
    @SerializedName("fullAddress")
    val fullAddress: String, // test
    @SerializedName("_id")
    val id: String, // 64660f0b67fa70c4180bab46
    @SerializedName("latitude")
    val latitude: String, // 0
    @SerializedName("longitude")
    val longitude: String, // -1
    @SerializedName("pickUpDate")
    val pickUpDate: String, // 17-05-2023
    @SerializedName("pickUpTime")
    val pickUpTime: String // 10:02AM
)