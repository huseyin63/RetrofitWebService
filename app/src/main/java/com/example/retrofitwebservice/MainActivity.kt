package com.example.retrofitwebservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kisiSil()
        //kisiEkle()
        //kisiGuncelle()
        //tumkisiler()
        kisiarama()
    }

    // delete İşlemi
    fun kisiSil() {

        val kisilerDao = ApiUtils.getKisilerDao()
        kisilerDao.kisiSil(2).enqueue(object : Callback<CRUDCevap> {

            // Cevabı burada alıyoruz
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Başarı", response.body()?.success.toString())
                    Log.e("Mesaj", response.body()?.message.toString())
                }
            }

            // Hata oldugunda bize hata sonucunu döndürür
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }


        })
    }

    fun kisiEkle() {
        val kisilerDao = ApiUtils.getKisilerDao()
        kisilerDao.kisiEkle("retrofit","02123102546").enqueue(object : Callback<CRUDCevap> {
            // Cevabı burada alıyoruz
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Başarı", response.body()?.success.toString())
                    Log.e("Mesaj", response.body()?.message.toString())
                }
            }
            // Hata oldugunda bize hata sonucunu döndürür
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            }
        })
    }


    fun kisiGuncelle(){
        val kisilerDao = ApiUtils.getKisilerDao()
        kisilerDao.kisiGuncelle(1,"Murtaza","0333 644 54 15").enqueue(object : Callback<CRUDCevap> {
            // Cevabı burada alıyoruz
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e("Başarı", response.body()?.success.toString())
                    Log.e("Mesaj", response.body()?.message.toString())
                }
            }
            // Hata oldugunda bize hata sonucunu döndürür
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            }
        })

    }


    fun tumkisiler(){
        val kisilerDao = ApiUtils.getKisilerDao()

        kisilerDao.tumkisiler().enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {

                if(response != null){
                    val kisilerListe = response.body()?.kisiler

                    if (kisilerListe != null){
                        for(k in kisilerListe){
                            Log.e("******","********")
                            Log.e("Kişi id",k.kisi_id.toString())
                            Log.e("Kişi Ad",k.kisi_ad)
                            Log.e("Kişi Tel",k.kisi_tel)
                        }
                    }
                }

            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

            }


        })
    }



    fun kisiarama(){
        val kisilerDao = ApiUtils.getKisilerDao()
        kisilerDao.kisiarama("Murtaza").enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if(response != null){

                    val kisilerListe = response.body()?.kisiler

                    if (kisilerListe != null){
                        for(k in kisilerListe){
                            Log.e("******","********")
                            Log.e("Kişi id",k.kisi_id.toString())
                            Log.e("Kişi Ad",k.kisi_ad)
                            Log.e("Kişi Tel",k.kisi_tel)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

            }


        })












    }



}