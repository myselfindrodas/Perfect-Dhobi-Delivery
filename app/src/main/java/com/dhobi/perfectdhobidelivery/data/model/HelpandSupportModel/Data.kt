package com.dhobi.perfectdhobidelivery.data.model.HelpandSupportModel


import com.dhobi.perfectdhobidelivery.data.model.HelpandSupportModel.HelpAndSupport
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("helpAndSupports")
    val helpAndSupports: List<HelpAndSupport>
)