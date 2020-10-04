package com.sablab.spotsat.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sablab.spotsat.Satalite

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<ArrayList<Satalite>>().apply {
        val array = ArrayList<Satalite>()
        array.add(Satalite())
        value = array
    }
    val arrayList: LiveData<ArrayList<Satalite>> = _text
}