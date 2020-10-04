package com.sablab.spotsat

import android.location.LocationManager
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchActivity : AppCompatActivity() {
    var recyclerView:RecyclerView? = null
    var locationManager:LocationManager? = null
    var searchBar :EditText? = null
    var  searchButton : ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        supportActionBar?.hide()
        recyclerView = findViewById(R.id.recycler_view)
        searchBar = findViewById(R.id.editTextTextPersonName)
        searchButton = findViewById(R.id.search)
        searchButton?.setOnClickListener {
            var arrayList :ArrayList<Satalite>
            var query:String = searchBar?.text.toString().trim()
            GlobalScope.launch {
                withContext(Dispatchers.IO){
             arrayList =    HtmlScrapper().scrapSearchResults(query)
            }
                withContext(Dispatchers.Main){
                    recyclerView?.adapter = ListAdapter(arrayList!!)
                    recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
                }
            }
        }
        GlobalScope.launch {
            var arrayList: ArrayList<Satalite>? = null
            withContext(Dispatchers.IO) {
               arrayList = NetworkHandler().getNearBySatalites()
               var sata =  Satalite()
                sata.name = "ITS WORKING SOMETHING IS WRONG"
                arrayList?.add(sata)
            }
            withContext(Dispatchers.Main){
                runOnUiThread(object : Runnable{
                    override fun run() {
                        recyclerView?.adapter = ListAdapter(arrayList!!)
                        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
                    }
                })

            }
        }
    }
}