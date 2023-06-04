package com.shehzad.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModal(application: Application) :AndroidViewModel(application){

    val  allNotes: LiveData<List<Note>>
    val repo : Repo

    init {
        val dao = Database.getDatabaseInstance(application)?.getDao()
        repo=Repo(dao!!)
        allNotes = repo.allNotes
    }
    fun deleteNote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        repo.delete(note)
    }
    fun updateNote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        repo.update(note)
    }
    fun addNote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        repo.insert(note)
    }
}