package com.example.exchangerate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.TableRows
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Navigation(val route: String, val icon: ImageVector, val title: String) {
    object Popular : Navigation("popular",  icon = Icons.Filled.TableRows,"Популярное")
    object Favorites : Navigation("favorites", icon = Icons.Filled.Favorite,  "Избранное")
}