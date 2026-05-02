package com.example.tarea_n2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tarea_n2.ui.screens.HomeScreen
import com.example.tarea_n2.ui.screens.DetailScreen
import com.example.tarea_n2.ui.screens.form.FormScreenCategory
import com.example.tarea_n2.ui.screens.form.FormScreenEvent
import com.example.tarea_n2.ui.screens.form.FormViewModelCategory
import com.example.tarea_n2.ui.screens.form.FormViewModelEvent
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object FormCategory

@Serializable
object FormEvent

@Serializable
data class Detail(val eventId: Int)

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val viewModel: FormViewModelCategory = viewModel()
    val viewModeltwo: FormViewModelEvent = viewModel()

    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController, viewModel, viewModeltwo)
        }

        composable<FormCategory> {
            FormScreenCategory(navController, viewModel)
        }

        composable<FormEvent> {
            FormScreenEvent(navController, viewModeltwo, viewModel)
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(navController, detail.eventId, viewModeltwo)
        }
    }
}
