package com.example.ccontectssmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ccontectssmvvm.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {

    fun buttonGuncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        krepo.buttonGuncelle(kisi_id, kisi_ad, kisi_tel)
    }
}