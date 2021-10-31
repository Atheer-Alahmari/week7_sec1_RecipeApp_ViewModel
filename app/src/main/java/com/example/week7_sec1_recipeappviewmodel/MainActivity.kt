package com.example.week7_sec1_recipeappviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.week7_sec1_recipeappviewmodel.Live_Data.MyViewModel
import com.example.week7_sec1_recipeappviewmodel.models.Book
import com.example.week7_sec1_recipeappviewmodel.models.BookDataBase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   // lateinit var myDBRoom:BookDataBase
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}//------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  myDBRoom= BookDataBase.getInstance(this)


        save_btn.setOnClickListener {

            var title = title_ED.text.toString()
            var author = author_ED.text.toString()
            var inge = inge_ED.text.toString()
            var ins = instr_ED.text.toString()

            if (title.isNotEmpty() && author.isNotEmpty() && inge.isNotEmpty() && ins.isNotEmpty()) {
                //----------------Save DB--------------
               // var f =(Book(0,title, author, inge, ins))
               // myDBRoom.BookDao1().insertBook(f)
                myViewModel.add_Book(title, author, inge, ins)
                Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(applicationContext, "Please Enter All  ", Toast.LENGTH_SHORT).show()

            }
            title_ED.text.clear()
            author_ED.text.clear()
            inge_ED.text.clear()
            instr_ED.text.clear()
        }
    }


    fun viewreceipe(view: android.view.View) {
        intent = Intent(applicationContext, Update_Delete_user::class.java)
        startActivity(intent)
    }}
