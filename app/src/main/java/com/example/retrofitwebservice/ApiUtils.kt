package com.example.retrofitwebservice

import retrofit2.create

class ApiUtils {

    companion object{

        val BASE_URL = "http://huseyin63.xyz/"

        fun getKisilerDao():KisilerDao{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDao::class.java)
        }

    }
}