package com.sablab.spotsat

import android.util.JsonReader
import android.util.Log

class JsonParser {
    fun getNearBySats(jsonReader: JsonReader): ArrayList<Satalite>? {
        Log.d("See this" , "GETNEARBYSATS WAS CALLED")
        jsonReader.beginObject()
        var arrayList:ArrayList<Satalite>? = ArrayList()
        while (jsonReader.hasNext()) {
            val key: String = jsonReader.nextName()
            if (key =="above") {
               arrayList= getArrayOfSats(jsonReader)
            }else{
                jsonReader.skipValue()
            }
        }
        return arrayList
    }

    private fun getArrayOfSats(jsonReader: JsonReader):ArrayList<Satalite> {
        Log.d("See this" , "GETARRAYOFSATs WAS CALLED")
        var arrayList:ArrayList<Satalite> = ArrayList()
        jsonReader.beginArray()
        while (jsonReader.hasNext()){
            arrayList.add(getSats(jsonReader))
        }
        jsonReader.endArray()
        return arrayList
    }

    private fun getSats(jsonReader: JsonReader):Satalite {
        Log.d("See this" , "GETSATS WAS CALLED")

        val satalie = Satalite()
            jsonReader.beginObject()
            while (jsonReader.hasNext()){
                val key: String = jsonReader.nextName()
                if (key =="satid"){
                    satalie.idNum = jsonReader.nextInt().toString()
                    Log.d("SEE THIS ","${satalie.idNum}")
                }
                else if (key=="satname"){
                    satalie.name = jsonReader.nextString()
                }
                else if(key=="satlat"){
                    satalie.lat = jsonReader.nextDouble()
                }
                else if(key =="satlng"){
                    satalie.long = jsonReader.nextDouble()
                }
                else if(key == "satalt"){
                    satalie.alt = jsonReader.nextDouble()
                }else{
                    jsonReader.skipValue()

                }

            }
        jsonReader.endObject()
    return satalie}
}