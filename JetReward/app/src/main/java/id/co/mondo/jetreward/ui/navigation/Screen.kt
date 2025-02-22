package id.co.mondo.jetreward.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Cart : Screen("cart")
    data object Profile : Screen("profile")
}