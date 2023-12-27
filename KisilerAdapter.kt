package com.example.ccontectssmvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ccontectssmvvm.R
import com.example.ccontectssmvvm.data.entity.Kisiler
import com.example.ccontectssmvvm.databinding.CardTasarimBinding
import com.example.ccontectssmvvm.ui.fragment.AnasayfaFragmentDirections
import com.example.ccontectssmvvm.ui.viewmodel.AnasayfaViewModel
import com.example.ccontectssmvvm.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context, var kisilerListesi :List<Kisiler>,var viewModel: AnasayfaViewModel ) :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_tasarim,parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.kisiNesnesi=kisi

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToKisiDetayFragment(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                   viewModel.sil(kisi.kisi_id!!)
                }
                .show()
        }
    }


}