package com.example.bmjobathon.data.remote.webservice

import com.example.bmjobathon.data.remote.dto.GetDataDto
import com.example.bmjobathon.data.remote.dto.RatesResponse
import com.example.bmjobathon.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("api/latest")
    suspend fun getRates(@Query("access_key") accessKey: String = Constant.API_KEY): Response<RatesResponse>
}
