package com.ogungor.retrofit

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Call

interface RetroServiceInterface {


    @GET
    fun downloadPdfFile(@Url pdfUrl:String):Call<ResponseBody>


}