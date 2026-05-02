package com.example.tarea_n2.data.repository

import android.content.Context
import com.example.tarea_n2.data.local.AppDatabase
import com.example.tarea_n2.data.repository.category.CategoryRepository
import com.example.tarea_n2.data.repository.category.CategoryRepositoryImpl

interface AppContainer {
    val categoryRepository: CategoryRepository
}

class AppDataContainer(
    private val context: Context
) : AppContainer {

    override val categoryRepository: CategoryRepository by lazy {
        CategoryRepositoryImpl(
            AppDatabase.getDatabase(context)
        )
    }
}


