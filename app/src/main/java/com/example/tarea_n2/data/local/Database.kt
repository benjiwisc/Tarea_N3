package com.example.tarea_n2.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea_n2.data.local.dao.CategoryDao
import com.example.tarea_n2.data.local.entity.CategoryEntity
@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "App_database")
                    .fallbackToDestructiveMigration(true)
                    .build().also { Instance = it }
            }
        }

    }
}