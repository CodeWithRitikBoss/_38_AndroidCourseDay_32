package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

data class MyAPI_Data(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)