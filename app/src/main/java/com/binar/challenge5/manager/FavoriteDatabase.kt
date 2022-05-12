package com.binar.challenge5.manager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.binar.challenge5.model.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao() : FavoriteDao

    companion object{
        private var INSTANCE : FavoriteDatabase? = null
        fun getInstance(context : Context):FavoriteDatabase? {
            if (INSTANCE == null){
                synchronized(FavoriteDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FavoriteDatabase::class.java,"User.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        //       fun destroyInstance(){
        //          INSTANCE = null
        //      }
    }
}