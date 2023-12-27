package com.example.ccontectssmvvm.di

import com.example.ccontectssmvvm.data.datasource.KisilerDataSource
import com.example.ccontectssmvvm.data.repo.KisilerRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides

    @Singleton
    fun provideKisilerDataSource(collectionKisiler:CollectionReference) : KisilerDataSource{
        return KisilerDataSource(collectionKisiler)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }


    // firestorede tablo oluşturduk3
    @Provides
    @Singleton
    fun provideCollectionReferences() : CollectionReference{
        return Firebase.firestore.collection("Kisiler") // Kisiler tablomuz firestorede
    }



}