package com.example.week7_sec1_recipeappviewmodel.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Books")
data class Book (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id")val id:Int=0,
    @ColumnInfo(name="Title")val title:String="",
    @ColumnInfo(name="Author")val author:String="",
    @ColumnInfo(name="Ingredients")val ingredients:String="",
    @ColumnInfo(name="Instructions")val instructions:String=""
)

