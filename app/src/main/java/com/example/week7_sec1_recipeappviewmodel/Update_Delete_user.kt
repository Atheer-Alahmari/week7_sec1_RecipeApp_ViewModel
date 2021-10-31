package com.example.week7_sec1_recipeappviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week7_sec1_recipeappviewmodel.Live_Data.MyViewModel
import com.example.week7_sec1_recipeappviewmodel.models.Book
import com.example.week7_sec1_recipeappviewmodel.models.BookDataBase

class Update_Delete_user : AppCompatActivity() {
    // lateinit var myDBRoom: BookDataBase
    lateinit var list_b: List<Book>
    lateinit var list_RV: RecyclerView
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }//------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete_user)
        // myDBRoom = BookDataBase.getInstance(this)
        list_RV = findViewById(R.id.recycler_View)// Recycler View
        list_b = listOf()

        updateList()


    }

    fun updateList() {
        myViewModel.get_Book().observe(this, { books ->
            list_RV.adapter = RV_Adapter(this, books)
            list_RV.layoutManager = LinearLayoutManager(this)

            list_RV.scrollToPosition(books.size - 1)


        })

    }
}