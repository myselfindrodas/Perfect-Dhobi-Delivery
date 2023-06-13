package com.dhobi.perfectdhobidelivery.data.model.ProfileGetResponseModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("userData")
    val userData: UserData
)