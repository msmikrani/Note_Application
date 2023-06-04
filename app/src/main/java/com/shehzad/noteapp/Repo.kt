package com.shehzad.noteapp

import androidx.lifecycle.LiveData

class Repo(private val dao: Dao) {


    var allNotes: LiveData<List<Note>> = dao.getAllNotes()

    suspend  fun insert(note: Note){
        dao.insert(note)
    }
    suspend fun delete(note: Note){
        dao.delete(note)
    }
    suspend fun update(note: Note){
        dao.update(note)
    }




}