package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import retrofit2.Call
import retrofit2.http.GET


interface API_Interface {

    @GET("products")
    fun getProductData() : Call<MyAPI_Data>

}