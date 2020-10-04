package com.sablab.spotsat

import android.util.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkHandler {
    val latitude = 30.12303
    val longitude = 31.13571
    val urlString =
        "https://www.n2yo.com/rest/v1/satellite/above/${latitude}/${longitude}/0/12/0/&apiKey=4G5NAT-MWU6BZ-7CFHD8-4KCW/"

    suspend fun getHttpUrlConnection(): HttpURLConnection {

        val url: URL = URL(urlString)
        val httpURLConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "GET"
//            httpURLConnection.setRequestProperty("apiKey", "4G5NAT-MWU6BZ-7CFHD8-4KCW")
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                httpURLConnection.connect()
            }
        }

        return httpURLConnection
    }

    suspend fun getNearBySatalites(): ArrayList<Satalite>? {
        var arrayList: ArrayList<Satalite>? = ArrayList()


        val httpURLConnection = getHttpUrlConnection()
        val inputStreamReader = InputStreamReader(httpURLConnection.inputStream)
        val jsonReader = JsonReader(inputStreamReader)

        val jsonParser = JsonParser()
        arrayList = jsonParser.getNearBySats(jsonReader)

        return arrayList
    }

}