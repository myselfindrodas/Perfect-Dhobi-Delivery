package com.dhobi.perfectdhobidelivery.data.repository

import com.dhobi.perfectdhobidelivery.data.ApiHelper
import com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateRequestModel
import com.dhobi.perfectdhobidelivery.data.model.expriedotp.ExpriedOtpRequestModel
import com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginRequestModel
import com.dhobi.perfectdhobidelivery.data.model.otpmodel.OtpvalidateRequestModel
import okhttp3.MultipartBody


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun login(devicetype: String, key: String, source: String, requestBody: LoginRequestModel) =
        apiHelper.login(devicetype,key,source, requestBody)


    suspend fun validateotp(devicetype: String, key: String, source: String, requestBody: OtpvalidateRequestModel) =
        apiHelper.validateotp(devicetype,key,source, requestBody)


    suspend fun expireotp(devicetype: String, key: String, source: String, requestBody: ExpriedOtpRequestModel) =
        apiHelper.expireotp(devicetype,key,source, requestBody)


    suspend fun resendotp(devicetype: String, key: String, source: String, requestBody: ExpriedOtpRequestModel) =
        apiHelper.resendotp(devicetype,key,source, requestBody)


    suspend fun logout(devicetype: String, key: String, source: String) = apiHelper.logout(devicetype,key,source)

    suspend fun userprofile(devicetype: String, key: String, source: String) = apiHelper.userprofile(devicetype,key,source)

    suspend fun updateprofile(devicetype: String, key: String, source: String, requestBody: ProfileUpdateRequestModel) = apiHelper.updateprofile(devicetype,key,source, requestBody)

    suspend fun profilepicupdate(devicetype: String, key: String, source: String, part: MultipartBody.Part) = apiHelper.profilepicupdate(devicetype,key,source,part)


    suspend fun assignedslottodaydelivery(devicetype: String, key: String, source: String) = apiHelper.assignedslottodaydelivery(devicetype,key,source)

    suspend fun notificationlist(devicetype: String, key: String, source: String) = apiHelper.notificationlist(devicetype,key,source)

    suspend fun helpandsupportlist(devicetype: String, key: String, source: String) = apiHelper.helpandsupportlist(devicetype,key,source)


    suspend fun faq(devicetype: String, key: String, source: String) = apiHelper.faq(devicetype,key,source)


    suspend fun ratechartlist(devicetype: String, key: String, source: String) = apiHelper.ratechartlist(devicetype,key,source)

//    suspend fun login(requestBody: LoginRequestModel) = apiHelper.login(requestBody)
//    suspend fun urclist(requestBody: UrcRequestModel) = apiHelper.urclist(requestBody)
//    suspend fun categoryall(requestBody: CategoryRequestModel) = apiHelper.categoryall(requestBody)
//    suspend fun getAllProduct(requestBody: ProductListRequestModel,page:String) = apiHelper.getAllProduct(requestBody,page)
//    suspend fun getProductDetails(id:String) = apiHelper.getProductDetails(id)
//    suspend fun dashboard(requestBody: DashboardRequestModel) = apiHelper.dashboard(requestBody)
//    suspend fun logout() = apiHelper.logout()
//    suspend fun forgotpassword(requestBody: ForgetPassRequestModel) = apiHelper.forgotpassword(requestBody)
//    suspend fun cartadd(requestBody: CartRequestModel) = apiHelper.cartadd(requestBody)
//    suspend fun cartDelete(id:String) = apiHelper.cartDelete(id)
//    suspend fun cartList() = apiHelper.cartList()
//    suspend fun addressList() = apiHelper.addressList()
//    suspend fun addAddress(requestBody: AddAddressRequestModel) = apiHelper.addAddress(requestBody)
//    suspend fun editAddress(requestBody: AddAddressRequestModel) = apiHelper.editAddress(requestBody)
//    suspend fun deleteAddress(id:String) = apiHelper.deleteAddress(id)
//    suspend fun primaryAddress(id:String) = apiHelper.primaryAddress(id)
//    suspend fun addtoWishlist(requestBody: AddWishlistRequestModel) = apiHelper.addtoWishlist(requestBody)
//    suspend fun wishlist() = apiHelper.wishlist()
//    suspend fun wishlistDelete(id:String) = apiHelper.wishlistDelete(id)
//    suspend fun notificationlist() = apiHelper.notificationlist()
//    suspend fun addpaymentcard(requestBody: AddcardRequestModel) = apiHelper.addpaymentcard(requestBody)
//    suspend fun paymentcardlist() = apiHelper.paymentcardlist()
//    suspend fun paymentcardPrimary(id:String) = apiHelper.paymentcardPrimary(id)
//    suspend fun paymentcardDelete(id:String) = apiHelper.paymentcardDelete(id)
//    suspend fun addOrderDetails(requestBody: AddOrderRequestModel) = apiHelper.addOrderDetails(requestBody)
//    suspend fun orderSummeryDetails() = apiHelper.orderSummeryDetails()
//    suspend fun myOrderList() = apiHelper.myOrderList()
//    suspend fun orderDetails(id:String) = apiHelper.orderDetails(id)
//    suspend fun getSupportAndFAQ(id:String) = apiHelper.getSupportAndFAQ(id)
//    suspend fun orderpayment(requestBody: OrderPaymentRequestModel) = apiHelper.orderpayment(requestBody)
//
//    suspend fun profileupdate(
//        name: RequestBody,
//        last_name: RequestBody,
//        phone: RequestBody,
//        gender: RequestBody,
//        birthday: RequestBody,
//        password: RequestBody,
//        old_password: RequestBody,
//        part: MultipartBody.Part) = apiHelper.profileupdate(name, last_name, phone, gender, birthday, password, old_password, part)
//
//    suspend fun profileget() = apiHelper.profileget()
//    suspend fun filterResponse() = apiHelper.filterResponse()
}