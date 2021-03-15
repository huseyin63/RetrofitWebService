package com.example.retrofitwebservice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KisilerCevap(
    @SerializedName("kisiler")
    @Expose
    var kisiler:List<Kisiler>,
    @SerializedName("success")
    @Expose
    var success:Int


)
