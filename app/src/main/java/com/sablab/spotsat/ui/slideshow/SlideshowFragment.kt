package com.sablab.spotsat.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sablab.spotsat.ListAdapter
import com.sablab.spotsat.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private var recyclerView:RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.let {
            slideshowViewModel =
                ViewModelProviders.of(it).get(SlideshowViewModel::class.java)
        }

        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        recyclerView = root?.findViewById(R.id.recycler_view)
//        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.arrayList?.observe(viewLifecycleOwner, Observer{
            recyclerView?.layoutManager = LinearLayoutManager(root?.context)
            recyclerView?.adapter = ListAdapter(it)
        })
        return root
    }
}