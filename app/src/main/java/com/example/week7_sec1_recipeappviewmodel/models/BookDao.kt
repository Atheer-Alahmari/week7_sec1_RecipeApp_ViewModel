package com.example.week7_sec1_recipeappviewmodel.models

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface BookDao {
    @Query("SELECT * FROM Books /* ORDER BY Note DESC*/")
    fun getAllBooks(): LiveData<List<Book>>

    @Insert
    fun insertBook(input: Book)
    @Delete
    fun deleteBook(id: Book)

    @Update
    fun updateBook(id: Book)
}