package com.dhobi.perfectdhobidelivery.data.model.FAQmodel


import com.dhobi.perfectdhobidelivery.data.model.HelpandSupportModel.HelpAndSupport
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("faq")
    val faq: List<HelpAndSupport>
)