package com.example.ccontectssmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.ccontectssmvvm.R
import com.example.ccontectssmvvm.databinding.FragmentKisiDetayBinding
import com.example.ccontectssmvvm.ui.viewmodel.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay,container, false)

        binding.kisiDetayNesnesi= this
        binding.toolbarBaslik = "Kişi Detay"

        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.kisiNesnesi = gelenKisi


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel=tempViewModel

    }

    fun buttonGuncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        viewModel.buttonGuncelle(kisi_id, kisi_ad, kisi_tel)
    }

}