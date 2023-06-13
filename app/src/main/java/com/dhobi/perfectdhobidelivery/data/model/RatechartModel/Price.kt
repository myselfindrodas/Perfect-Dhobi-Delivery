package com.dhobi.perfectdhobidelivery.data.model.RatechartModel


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("$"+"numberDecimal")
    val numberDecimal: String // 49.00
)