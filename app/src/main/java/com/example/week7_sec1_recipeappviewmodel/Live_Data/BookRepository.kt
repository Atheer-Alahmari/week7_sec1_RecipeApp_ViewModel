package com.example.week7_sec1_recipeappviewmodel.Live_Data

import androidx.lifecycle.LiveData
import com.example.week7_sec1_recipeappviewmodel.models.Book
import com.example.week7_sec1_recipeappviewmodel.models.BookDao

class BookRepository (private  val myBookDao: BookDao){
    val getAll_book: LiveData<List<Book>> = myBookDao.getAllBooks()

    fun add(b:Book){
        myBookDao.insertBook(b)
    }
    fun update(b:Book){
        myBookDao.updateBook(b)
    }
    fun delete(b:Book){
        myBookDao.deleteBook(b)
    }
}