package com.example.week7_sec1_recipeappviewmodel.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Book::class],version = 1,exportSchema = false)
abstract class BookDataBase: RoomDatabase() {

    companion object{
        var instance: BookDataBase?=null
        fun getInstance(ctx: Context): BookDataBase
        {
            if(instance!=null)
            {
                return  instance as BookDataBase;
            }
            instance= Room.databaseBuilder(ctx,BookDataBase::class.java,"somename").run { allowMainThreadQueries() }.build();
            return instance as BookDataBase
        }
    }
    abstract fun BookDao1():BookDao
}