package com.dhobi.perfectdhobidelivery.data.model.AssignOrderTodayDeliveryModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("assignedSlots")
    val assignedSlots: List<AssignedSlot>,
    @SerializedName("todayDelivery")
    val todayDelivery: List<Any>
)