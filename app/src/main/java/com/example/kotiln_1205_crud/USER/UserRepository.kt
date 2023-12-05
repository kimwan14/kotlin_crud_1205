package com.example.kotiln_1205_crud.USER

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val getAll: LiveData<List<UserTable>> = userDao.getAll()

    suspend fun addUser(userTable: UserTable){ // suspend를 붙인 이유는 coroutine을 사용하기 위함
        userDao.addUser(userTable)
    }
}