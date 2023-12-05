package com.example.kotiln_1205_crud.USER

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        @Volatile // 다른 쓰레드에서 접근 가능하게 만드는 것
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            val instance = INSTANCE
            if(instance != null){
                return  instance
            }
            synchronized(this){
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "USER"
                ).build()
                INSTANCE = _instance
                return _instance
            }
        }
    }
}