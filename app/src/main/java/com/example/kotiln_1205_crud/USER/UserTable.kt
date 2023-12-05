package com.example.kotiln_1205_crud.USER

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserTable (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val job: String,
    val age: String
)