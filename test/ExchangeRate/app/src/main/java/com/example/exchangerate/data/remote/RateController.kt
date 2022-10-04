package com.example.exchangerate.data.remote

import com.example.exchangerate.data.remote.entities.AllData
import retrofit2.http.GET

interface RateController {
    @GET("daily_json.js")
    suspend fun getRateAsync(): AllData
}