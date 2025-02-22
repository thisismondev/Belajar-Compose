package id.co.mondo.jetreward.di

import id.co.mondo.jetreward.data.RewardRepository

object Injection {
    fun provideRepository(): RewardRepository{
        return RewardRepository.getInstance()
    }
}