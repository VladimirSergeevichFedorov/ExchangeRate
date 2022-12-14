package com.example.exchangerate.ui.viewbar

import androidx.compose.foundation.border
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.exchangerate.R
import com.example.exchangerate.navigation.Navigation

private const val FONT_SIZE = 13

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Navigation.Popular,
        Navigation.Favorites
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onSecondary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier
                    .border(
                        width = dimensionResource(R.dimen.one_dp),
                        color = MaterialTheme.colors.background
                    ),
                icon = { Icon(item.icon, null) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = FONT_SIZE.sp
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}