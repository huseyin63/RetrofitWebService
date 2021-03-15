package com.example.retrofitwebservice

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {

    // Delete İşlemi
    // POST methodu  veri göndermemizi sağlıyor
    @POST("deneme/delete_kisiler.php")
    @FormUrlEncoded //Türkçe karakter desteği verir

    fun kisiSil(@Field("kisi_id") kisi_id:Int):Call<CRUDCevap>


    //İnsert İşlemi
    @POST("deneme/insert_kisiler.php")
    @FormUrlEncoded
    fun kisiEkle(@Field("kisi_ad") kisi_ad:String
                 ,@Field("kisi_tel") kisi_tel:String):Call<CRUDCevap>


    // Update islemi
    @POST("deneme/update_kisiler.php")
    @FormUrlEncoded

    fun kisiGuncelle(@Field("kisi_id") kisi_id:Int
                    ,@Field("kisi_ad") kisi_ad:String
                    ,@Field("kisi_tel") kisi_tel:String):Call<CRUDCevap>

    // Veri okuma işlemi
    @GET("deneme/tum_kisiler.php")

    fun tumkisiler():Call<KisilerCevap>

    // Arama islemi
    @POST("deneme/tum_kisiler_arama.php")
    @FormUrlEncoded

    fun kisiarama(@Field("kisi_ad") kisi_ad:String):Call<KisilerCevap>




}