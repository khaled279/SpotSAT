package com.sablab.spotsat.ui.slideshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sablab.spotsat.Satalite

class SlideshowViewModel : ViewModel() {


     var arrayList: MutableLiveData<ArrayList<Satalite>>? =null

        get() {
            return arrayList
        }


    fun setUsers(satalites: ArrayList<Satalite>) {
        arrayList = MutableLiveData(satalites)
        arrayList?.value = satalites
    }
}