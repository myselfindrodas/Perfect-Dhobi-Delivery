package com.dhobi.perfectdhobidelivery.data.modelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhobi.perfectdhobidelivery.data.ApiHelper
import com.dhobi.perfectdhobidelivery.data.repository.MainRepository
import com.dhobi.perfectdhobidelivery.viewmodel.CommonViewModel

class CommonModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        CommonViewModel(MainRepository(apiHelper)) as T
}