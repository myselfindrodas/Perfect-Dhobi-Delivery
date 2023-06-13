package com.dhobi.perfectdhobidelivery.data

import com.dhobi.perfectdhobidelivery.data.ApiInterface
import com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateRequestModel
import com.dhobi.perfectdhobidelivery.data.model.expriedotp.ExpriedOtpRequestModel
import com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginRequestModel
import com.dhobi.perfectdhobidelivery.data.model.otpmodel.OtpvalidateRequestModel
import okhttp3.MultipartBody


class ApiHelper(private val apiInterface: ApiInterface) {

    suspend fun login(devicetype: String, key: String, source: String, requestBody: LoginRequestModel) =
        apiInterface.login(devicetype,key,source, requestBody)


    suspend fun validateotp(devicetype: String, key: String, source: String, requestBody: OtpvalidateRequestModel) =
        apiInterface.validateotp(devicetype,key,source, requestBody)


    suspend fun expireotp(devicetype: String, key: String, source: String, requestBody: ExpriedOtpRequestModel) =
        apiInterface.expireotp(devicetype,key,source, requestBody)


    suspend fun resendotp(devicetype: String, key: String, source: String, requestBody: ExpriedOtpRequestModel) =
        apiInterface.resendotp(devicetype,key,source, requestBody)


    suspend fun logout(devicetype: String, key: String, source: String) =
        apiInterface.logout(devicetype,key,source)


    suspend fun userprofile(devicetype: String, key: String, source: String) = apiInterface.userprofile(devicetype,key,source)

    suspend fun updateprofile(devicetype: String, key: String, source: String, requestBody: ProfileUpdateRequestModel) = apiInterface.updateprofile(devicetype,key,source, requestBody)


    suspend fun profilepicupdate(devicetype: String, key: String, source: String, part: MultipartBody.Part) = apiInterface.profilepicupdate(devicetype,key,source,part)

    suspend fun assignedslottodaydelivery(devicetype: String, key: String, source: String) = apiInterface.assignedslottodaydelivery(devicetype,key,source)


    suspend fun notificationlist(devicetype: String, key: String, source: String) = apiInterface.notificationlist(devicetype,key,source)

    suspend fun helpandsupportlist(devicetype: String, key: String, source: String) = apiInterface.helpandsupportlist(devicetype,key,source)


    suspend fun faq(devicetype: String, key: String, source: String) = apiInterface.faq(devicetype,key,source)


    suspend fun ratechartlist(devicetype: String, key: String, source: String) = apiInterface.ratechartlist(devicetype,key,source)


//    suspend fun login(requestBody: LoginRequestModel) = apiInterface.login(requestBody)
//    suspend fun urclist(requestBody: UrcRequestModel) = apiInterface.urclist(requestBody)
//    suspend fun categoryall(requestBody: CategoryRequestModel) = apiInterface.categoryall(requestBody)
//    suspend fun getAllProduct(requestBody: ProductListRequestModel,page:String) = apiInterface.productList(requestBody,page)
//    suspend fun getProductDetails(id:String) = apiInterface.getProductDetails(id)
//    suspend fun dashboard(requestBody: DashboardRequestModel) = apiInterface.dashboard(requestBody)
//    suspend fun logout() = apiInterface.logout()
//    suspend fun forgotpassword(requestBody: ForgetPassRequestModel) = apiInterface.forgotpassword(requestBody)
//    suspend fun cartadd(requestBody: CartRequestModel) = apiInterface.cartadd(requestBody)
//    suspend fun cartDelete(id:String) = apiInterface.cartDelete(id)
//    suspend fun cartList() = apiInterface.cartList()
//    suspend fun addressList() = apiInterface.addressList()
//    suspend fun addAddress(requestBody: AddAddressRequestModel) = apiInterface.addAddress(requestBody)
//    suspend fun editAddress(requestBody: AddAddressRequestModel) = apiInterface.editAddress(requestBody)
//    suspend fun deleteAddress(id:String) = apiInterface.addressDelete(id)
//    suspend fun primaryAddress(id:String) = apiInterface.addressPrimary(id)
//    suspend fun addtoWishlist(requestBody: AddWishlistRequestModel) = apiInterface.addtoWishlist(requestBody)
//    suspend fun wishlist() = apiInterface.wishlist()
//    suspend fun wishlistDelete(id:String) = apiInterface.wishlistDelete(id)
//    suspend fun notificationlist() = apiInterface.notificationlist()
//    suspend fun addpaymentcard(requestBody: AddcardRequestModel) = apiInterface.addpaymentcard(requestBody)
//    suspend fun paymentcardlist() = apiInterface.paymentcardlist()
//    suspend fun paymentcardPrimary(id:String) = apiInterface.paymentcardPrimary(id)
//    suspend fun paymentcardDelete(id:String) = apiInterface.paymentcardDelete(id)
//    suspend fun addOrderDetails(requestBody: AddOrderRequestModel) = apiInterface.addOrderDetails(requestBody)
//    suspend fun orderSummeryDetails() = apiInterface.orderSummeryDetails()
//    suspend fun myOrderList() = apiInterface.myOrderList()
//    suspend fun orderDetails(id:String) = apiInterface.orderDetails(id)
//    suspend fun getSupportAndFAQ(id:String) = apiInterface.getSupportAndFAQ(id)
//    suspend fun orderpayment(requestBody: OrderPaymentRequestModel) = apiInterface.orderpayment(requestBody)
//
//    suspend fun profileupdate(
//        name: RequestBody,
//        last_name: RequestBody,
//        phone: RequestBody,
//        gender: RequestBody,
//        birthday: RequestBody,
//        password: RequestBody,
//        old_password: RequestBody,
//        part: MultipartBody.Part) = apiInterface.profileupdate(name, last_name, phone, gender, birthday, password, old_password, part)
//
//
//    suspend fun profileget() = apiInterface.profileget()
//    suspend fun filterResponse() = apiInterface.filterResponse()
}