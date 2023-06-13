package com.dhobi.perfectdhobidelivery.data

import com.dhobi.perfectdhobidelivery.data.model.AssignOrderTodayDeliveryModel.AssignOrderTodayDeliveryResponseModel
import com.dhobi.perfectdhobidelivery.data.model.FAQmodel.FAQResponseModel
import com.dhobi.perfectdhobidelivery.data.model.HelpandSupportModel.HelpandSupportResponseModel
import com.dhobi.perfectdhobidelivery.data.model.ProfileGetResponseModel.ProfileGetResponseModel
import com.dhobi.perfectdhobidelivery.data.model.ProfilePictureModel.ProfilePicResponseModel
import com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateRequestModel
import com.dhobi.perfectdhobidelivery.data.model.ProfileUpdateModel.ProfileUpdateResponseModel.ProfileUpdateResponseModel
import com.dhobi.perfectdhobidelivery.data.model.RatechartModel.RatechartResponseModel
import com.dhobi.perfectdhobidelivery.data.model.expriedotp.ExpriedOtpRequestModel
import com.dhobi.perfectdhobidelivery.data.model.expriedotp.ExpriedOtpResponseModel.ExpriedOtpResponseModel
import com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginRequestModel
import com.dhobi.perfectdhobidelivery.data.model.loginmodel.LoginResponseModel.LoginResponseModel
import com.dhobi.perfectdhobidelivery.data.model.logoutmodel.LogoutResponseModel.LogoutResponseModel
import com.dhobi.perfectdhobidelivery.data.model.notificationmodel.NotificationResponseModel
import com.dhobi.perfectdhobidelivery.data.model.otpmodel.OtpvalidateRequestModel
import com.dhobi.perfectdhobidelivery.data.model.otpmodel.otpResponseModel.OtpResponseModel
import okhttp3.MultipartBody
import retrofit2.http.*


interface ApiInterface {

    @POST("sign-in")
    suspend fun login(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Body requestBody: LoginRequestModel
    ): LoginResponseModel


    @POST("validate-otp")
    suspend fun validateotp(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Body requestBody: OtpvalidateRequestModel
    ): OtpResponseModel



    @POST("expire-otp")
    suspend fun expireotp(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Body requestBody: ExpriedOtpRequestModel
    ): ExpriedOtpResponseModel



    @POST("resend-otp")
    suspend fun resendotp(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Body requestBody: ExpriedOtpRequestModel
    ): LoginResponseModel


    @POST("sign-out")
    suspend fun logout(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String
    ): LogoutResponseModel


    @GET("user-profile")
    suspend fun userprofile(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): ProfileGetResponseModel



    @POST("update-user-profile")
    suspend fun updateprofile(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Body requestBody: ProfileUpdateRequestModel
    ): ProfileUpdateResponseModel



    @Multipart
    @POST("update-profile-image")
    suspend fun profilepicupdate(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
        @Part file: MultipartBody.Part,
    ): ProfilePicResponseModel



    @GET("delivery/assigned-slots-and-today-delivery")
    suspend fun assignedslottodaydelivery(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): AssignOrderTodayDeliveryResponseModel



    @GET("delivery/notifications")
    suspend fun notificationlist(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): NotificationResponseModel



    @GET("delivery/help-and-support")
    suspend fun helpandsupportlist(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): HelpandSupportResponseModel



    @GET("delivery/faq")
    suspend fun faq(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): FAQResponseModel



    @GET("rate-chart")
    suspend fun ratechartlist(
        @Header("devicetype") devicetype: String,
        @Header("key") key: String,
        @Header("source") source: String,
    ): RatechartResponseModel

//    @POST("user/login")
//    suspend fun login(
//        @Body requestBody: LoginRequestModel
//    ): LoginResponseModel
//
//
//
//    @POST("user/urc-list")
//    suspend fun urclist(
//        @Body requestBody: UrcRequestModel
//    ): UrcModel
//
//
//    @POST("user/urc-category")
//    suspend fun categoryall(
//        @Body requestBody: CategoryRequestModel
//    ): CategoryResponseModel
//
//
//    @POST("user/urc-dashboard")
//    suspend fun dashboard(
//        @Body requestBody: DashboardRequestModel
//    ): DashboardResponseModel
//
//    @POST("user/urc-product-list")
//    suspend fun productList(
//        @Body requestBody: ProductListRequestModel,
//        @Query("page") page: String
//    ): ProductListResponseModel
//
//    @GET("user/urc-product-details/{id}")
//    suspend fun getProductDetails(
//        @Path("id") id: String
//    ): ProductDetailsResponseModel
//
//    @GET("user/logout")
//    suspend fun logout(
//    ): LogoutResponseModel
//
//    @POST("user/forgot-password")
//    suspend fun forgotpassword(
//        @Body requestBody: ForgetPassRequestModel
//    ): ForgetPasswordResponseModel
//
//
//    @POST("user/cart-add")
//    suspend fun cartadd(
//        @Body requestBody: CartRequestModel
//    ): CartResponseModel
//
//    @GET("user/cart-delete/{id}")
//    suspend fun cartDelete(
//        @Path("id") id: String
//    ): CartResponseModel
//
//    @GET("user/cart-list")
//    suspend fun cartList(): CartListResponseModel
//
//    @GET("user/address-list")
//    suspend fun addressList(): AddressListResponseModel
//
//    @GET("user/address-delete/{id}")
//    suspend fun addressDelete(
//        @Path("id") id: String
//    ): AddAddressResponseModel
//
//    @GET("user/address-primary/{id}")
//    suspend fun addressPrimary(
//        @Path("id") id: String
//    ): AddAddressResponseModel
//
//    @POST("user/address-add")
//    suspend fun addAddress(
//        @Body requestBody: AddAddressRequestModel
//    ): AddAddressResponseModel
//
//    @POST("user/address-edit")
//    suspend fun editAddress(
//        @Body requestBody: AddAddressRequestModel
//    ): AddAddressResponseModel
//
//
//    @POST("user/wishlist-add")
//    suspend fun addtoWishlist(
//        @Body requestBody: AddWishlistRequestModel
//    ): AddtowishlistResponseModel
//
//
//    @GET("user/wishlist-list")
//    suspend fun wishlist(): WishListResponseModel
//
//
//    @GET("user/wishlist-delete/{id}")
//    suspend fun wishlistDelete(
//        @Path("id") id: String
//    ): AddtowishlistResponseModel
//
//
//    @GET("user/notification-list")
//    suspend fun notificationlist(): NotificationModelResponse
//
//
//    @POST("user/paymentcard-add")
//    suspend fun addpaymentcard(
//        @Body requestBody: AddcardRequestModel
//    ): AddcardResponseModel
//
//    @GET("user/paymentcard-list")
//    suspend fun paymentcardlist(): SaveCardListResponseModel
//
//
//    @GET("user/paymentcard-primary/{id}")
//    suspend fun paymentcardPrimary(
//        @Path("id") id: String
//    ): AddPaymentPrimaryCardResponse
//
//
//    @GET("user/paymentcard-delete/{id}")
//    suspend fun paymentcardDelete(
//        @Path("id") id: String
//    ): AddPaymentPrimaryCardResponse
//
//
//    @GET("user/order-summary")
//    suspend fun orderSummeryDetails(): OrderSummeryResponseModel
//
//    @GET("user/order-list")
//    suspend fun myOrderList(): MyOrderListResponseModel
//
//    @POST("user/add-order")
//    suspend fun addOrderDetails(
//        @Body requestBody: AddOrderRequestModel
//    ): AddOrderResponseModel
//
//    @GET("user/order-details/{id}")
//    suspend fun orderDetails(
//        @Path("id") id: String
//    ): OrderDetailsResponseModel
//
//    @GET("user/content-lists/{id}")
//    suspend fun getSupportAndFAQ(
//        @Path("id") id: String
//    ): SupportFAQResponseModel
//
//
//    @POST("user/order-payment")
//    suspend fun orderpayment(
//        @Body requestBody: OrderPaymentRequestModel
//    ): OrderPaymentResponseModel
//
//    @Multipart
//    @POST("user/profile-edit")
//    suspend fun profileupdate(
//        @Part("name") name: RequestBody,
//        @Part("last_name") last_name: RequestBody,
//        @Part("phone") phone: RequestBody,
//        @Part("gender") gender: RequestBody,
//        @Part("birthday") birthday: RequestBody,
//        @Part("password") password: RequestBody,
//        @Part("old_password") old_password: RequestBody,
//        @Part file: MultipartBody.Part,
//    ): ProfileUpdateResponseModel
//
//
//
//    @GET("user/profile")
//    suspend fun profileget(): ProfileDetailsResponse
//
//    @GET("user/attribute-list")
//    suspend fun filterResponse(): FilterResponseModel

//    @Multipart
//    @POST(NetworkConstants.ENDPOINT_USER_REGISTER)
//    fun postRegister1(@Body registerRequest: RegisterRequest): Single<CommonResponseModel>
//
//    @Multipart
//    @POST(NetworkConstants.ENDPOINT_USER_REGISTER)
//    fun postRegister(
//        @Part("name") title: RequestBody,
//        @Part("email") email: RequestBody,
//        @Part("password") password: RequestBody,
//        @Part("society_id") societyId: RequestBody,
//        @Part aadharDocument: MultipartBody.Part,
//        @Part idFile: MultipartBody.Part,
//        @Part("phone_number") phone: RequestBody,
//        @Part("language") language: RequestBody,
//    ): Call<RegisterResponse?>
//
//    @Multipart
//    @POST(NetworkConstants.ENDPOINT_PROFILE_UPDATE)
//    fun postProfileUpdate(
//        @Part("name") title: RequestBody,
//        @Part("email") email: RequestBody,
//        @Part("society_id") societyId: RequestBody,
//        @Part aadharDocument: MultipartBody.Part,
//        @Part idFile: MultipartBody.Part,
//        @Part proileFile: MultipartBody.Part,
//        @Part("phone_number") phone: RequestBody,
//        @Part("user_id") userId: RequestBody,
//    ): Call<RegisterResponse?>
//
//    @GET(NetworkConstants.ENDPOINT_USER_MOBILE_OTP)
//    fun otp(@Query("phone_no") phone_no: Long): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_FORGET_PASS)
//    fun forgotPassword(@Body forgetPassRequestModel: ForgetPassRequestModel): Single<ForgetPasswordResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_LOGIN)
//    fun login(@Body loginRequestModel: LoginRequestModel): Single<LoginResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_CHANGE_LANGUAGE)
//    fun changeLanguage(@Body changeLanguageRequestModel: ChangeLanguageRequestModel): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_PROFILE_DETAILS)
//    fun profileDetails(@Body getProfileRequestModel: GetProfileRequestModel): Single<ProfileResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_HUB_LIST)
//    fun hubListDetails(@Body getProfileRequestModel: GetProfileRequestModel): Single<HubListResponse>
//
//    @POST(NetworkConstants.ENDPOINT_DELETE_CART_ITEM)
//    fun deleteCartItem(@Body deleteCartItemRequestModel: DeleteCartItemRequestModel): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_GET_CART)
//    fun getCartDetails(@Body getProfileRequestModel: GetProfileRequestModel): Single<GetCartResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_CART_CHECKOUT)
//    fun getCartCheckout(@Body checkoutRequestModel: CheckoutRequestModel): Single<CheckoutResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_CATEGORY_LIST)
//    fun categoryListDetails(@Body getProfileRequestModel: GetProfileRequestModel): Single<CategoryListResponse>
//    @POST(NetworkConstants.ENDPOINT_PAYMENT_STATUS)
//    fun postPaymentStatus(@Body paymentStatusRequestModel: PayNowRequestModel): Single<PayNowResponseModel>
//    @POST(NetworkConstants.ENDPOINT_ITEM_PARTICULAR_LIST)
//    fun itemParticularListDetails(@Body getItemParticulateRequestModel: GetItemParticulateRequestModel): Single<ItemParticualarResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_PAST_ORDER)
//    fun pastOrderListDetails(@Body profileRequestModel: GetProfileRequestModel): Single<MyOrderResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_UPCOMING_ORDER)
//    fun upcomingtOrderListDetails(@Body profileRequestModel: GetProfileRequestModel): Single<MyOrderResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_NOTIFICATION)
//    fun notificationListDetails(@Body profileRequestModel: GetProfileRequestModel): Single<NotificationResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_CHANGEPASSWORD)
//    fun changePassword(@Body changePasswordRequestModel: ChangePasswordRequestModel): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_SUPPLY_MILL_LIST)
//    fun millListDetails(@Body millRequestModel: SupplyMillRequestModel): Single<SupplyMillResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_ADD_TO_CART)
//    fun addToCart(@Body addToCartRequesModel: AddToCartRequesModel): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_PAY_NOW)
//    fun postPayNow(@Body payNowRequestModel: PayNowRequestModel): Single<PayNowResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_CREATE_PASSWORD)
//    fun createPassword(@Body loginRequestModel: LoginRequestModel): Single<CommonResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_USER_RESEND_OTP)
//    fun resendOTP(@Body forgetPassRequestModel: ForgetPassRequestModel): Single<ForgetPasswordResponseModel>
//
//    @GET(NetworkConstants.ENDPOINT_SOCIETY_LIST)
//    fun societyList(): Single<SocietyListResponseModel>
//
//    @POST(NetworkConstants.ENDPOINT_LOGOUT)
//    fun logout(@Body getProfileRequestModel: GetProfileRequestModel): Single<CommonResponseModel>

}