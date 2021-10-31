package com.example.week7_sec1_recipeappviewmodel.Live_Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.week7_sec1_recipeappviewmodel.models.Book
import com.example.week7_sec1_recipeappviewmodel.models.BookDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyViewModel(activity: Application): AndroidViewModel(activity) {

    private val myRepository: BookRepository
    private val book1: LiveData<List<Book>>

    init {
        val myDBRoom = BookDataBase.getInstance(activity).BookDao1()
        myRepository = BookRepository(myDBRoom)

        book1 = myRepository.getAll_book

    }

    fun get_Book(): LiveData<List<Book>> {
        return book1
    }

    fun add_Book(t: String,auth:String,ing:String,inst:String) {
        CoroutineScope(Dispatchers.IO).launch {

            myRepository.add(Book(0, t,auth,ing,inst))
        }
    }

    fun update_Book(id: Int,t: String,auth:String,ing:String,inst:String) {
        CoroutineScope(Dispatchers.IO).launch {
            myRepository.update(Book(id, t,auth,ing,inst))
        }
    }

    fun delete_Book(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            myRepository.delete(Book(id,""))
        }
    }


}