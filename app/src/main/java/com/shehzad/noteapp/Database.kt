package com.shehzad.noteapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Note::class), version = 1 , exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun getDao():Dao

    companion object{

        @Volatile
        private var INSTANCE : com.shehzad.noteapp.Database?=null

        fun getDatabaseInstance(context: Context): com.shehzad.noteapp.Database? {
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE=Room.databaseBuilder(context.applicationContext,
                        com.shehzad.noteapp.Database::class.java,
                        "note_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}