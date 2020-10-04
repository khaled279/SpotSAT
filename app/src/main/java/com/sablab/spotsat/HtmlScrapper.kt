package com.sablab.spotsat

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class HtmlScrapper {
    suspend fun scrapSearchResults(query: String): ArrayList<Satalite> {
        var listOfSATs: ArrayList<Satalite> = ArrayList()
        val doc: Document =
            Jsoup.connect("https://www.n2yo.com/database/?name=$query+#results").timeout(10000)
                .get()
        val table : Elements = doc.select("table.footable.table")
         var i = 0
        for (element in table.select("tr")) {
            if (i != 0 && i != 2) {
                val sat = Satalite()
                sat.name = element.getElementsByIndexEquals(0).select("a").text().trim()
                Log.d("Name", "${sat.name}")
                sat.idNum = element.getElementsByIndexEquals(1).text()
                Log.d("Name", "${sat.idNum}")
                sat.state = element.getElementsByIndexEquals(2).select("b").text().trim()
                Log.d("Name", "${sat.state}")
                listOfSATs.add(sat)
            }
            i++
        }
        return listOfSATs
    }
}