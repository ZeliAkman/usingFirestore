package com.example.ccontectssmvvm.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.ccontectssmvvm.data.datasource.KisilerDataSource
import com.example.ccontectssmvvm.data.entity.Kisiler

class KisilerRepository(var kds:KisilerDataSource) {

  fun kaydet(kisi_ad:String,kisi_tel:String)=kds.kaydet(kisi_ad,kisi_tel)

  fun buttonGuncelle(kisi_id:String,kisi_ad:String,kisi_tel:String) = kds.buttonGuncelle(kisi_id, kisi_ad, kisi_tel)

   fun sil(kisi_id:String) = kds.sil(kisi_id)

  fun kisileriYukle() : MutableLiveData<List<Kisiler>> = kds.kisileriYukle()

    fun ara(aramaKelimesi:String) :MutableLiveData<List<Kisiler>> = kds.ara(aramaKelimesi)


}