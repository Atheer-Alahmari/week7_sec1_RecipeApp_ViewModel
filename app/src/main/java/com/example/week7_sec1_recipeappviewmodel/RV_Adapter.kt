package com.example.week7_sec1_recipeappviewmodel

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.week7_sec1_recipeappviewmodel.Live_Data.MyViewModel
import com.example.week7_sec1_recipeappviewmodel.models.Book
import com.example.week7_sec1_recipeappviewmodel.models.BookDataBase
import kotlinx.android.synthetic.main.item_row.view.*

class RV_Adapter (val activity: Update_Delete_user, private val books:List<Book>): RecyclerView.Adapter<RV_Adapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val userId = books[position].id
        val titel = books[position].title
        val author = books[position].author
        val in1 =books[position].ingredients
        val is1=books[position].instructions


        holder.itemView.apply {
            text_View.text = titel
            text_View2.text = author
            text_View3.text = in1
            text_View4.text = is1

         //   var myDBRoom= BookDataBase.getInstance(activity)
             val myViewModel by lazy { ViewModelProvider(activity).get(MyViewModel::class.java)}//------------------------

            //-----------------------------AlertDialog---------------------------------------------------
            editIcon.setOnClickListener {
                var alt = AlertDialog.Builder(activity)
                alt.setTitle("Update Book ")
                val mLayout  = LinearLayout(activity)
                val mEtTitel = EditText(activity)
                val mEtAt = EditText(activity)
                val mEtIng = EditText(activity)
                val mEtInst = EditText(activity)

                mEtTitel.setSingleLine()
                mEtAt.setSingleLine()
                mEtIng.setSingleLine()
                mEtInst.setSingleLine()

                mLayout.orientation = LinearLayout.VERTICAL
                mLayout.addView(mEtTitel)
                mLayout.addView(mEtAt)
                mLayout.addView(mEtIng)
                mLayout.addView(mEtInst)
                mLayout.setPadding(50, 40, 50, 10)

                mEtTitel.setText(titel)
                mEtAt.setText(author)
                mEtIng.setText(in1)
                mEtInst.setText(is1)



                // --------------------Positive button text and action

                alt.setPositiveButton("Save", DialogInterface.OnClickListener { _, _ ->
                    //mEtName.setText(celeName)
                    var inputName = mEtTitel.text.toString()
                    var inputT1 = mEtAt.text.toString()
                    var inputT2 = mEtIng.text.toString()
                    var inputT3 = mEtInst.text.toString()

                   // myDBRoom.BookDao1().updateBook(Book(userId,inputName,inputT1,inputT2,inputT3))
myViewModel.update_Book(userId,inputName,inputT1,inputT2,inputT3)
                    activity.updateList()//text_View.text =input

                })


                // ------------------negative button text and action
                alt.setNegativeButton("Cansel", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()

                })

                val alt1: AlertDialog = alt.create()
                alt1.setCanceledOnTouchOutside(false)
                alt1.setView(mLayout)
                alt1.show()
            }
            //------------------------------------------------------------------------------------
            deleteIcon.setOnClickListener {
               // myDBRoom.BookDao1().deleteBook(Book(userId))
                myViewModel.delete_Book(userId)
                activity.updateList()
            }

        }
    }

    override fun getItemCount() = books.size
}
