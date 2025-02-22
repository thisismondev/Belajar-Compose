package id.co.mondo.jetreward.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.co.mondo.jetreward.data.RewardRepository
import id.co.mondo.jetreward.ui.screen.cart.CartViewModel
import id.co.mondo.jetreward.ui.screen.detail.DetailRewardViewModel
import id.co.mondo.jetreward.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: RewardRepository):
    ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailRewardViewModel::class.java)) {
            return DetailRewardViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}