package com.example.kotiln_1205_crud.USER

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    // AndroidViewModel : UI의 생명주기에 영향을 받지 않고 독립적으로 데이터 유지 가능

    private val readAllData: LiveData<List<UserTable>>
    private val repository: UserRepository

    init {
        val _userDao = UserDatabase.getDatabase(application)!!.userDao()
        repository = UserRepository(_userDao)
        readAllData = repository.getAll
    }

    fun addUser(userTable: UserTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(userTable)
        }
    }
}