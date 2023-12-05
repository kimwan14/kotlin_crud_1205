package com.example.kotiln_1205_crud.USER

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(userTable:UserTable)

    @Delete
    suspend fun delectUser(userTable:UserTable)

    @Update
    suspend fun updateUser(userTable:UserTable)

    @Query("select * from USER order by id asc")
    fun getAll():LiveData<List<UserTable>>
}