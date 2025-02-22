package id.co.mondo.jetreward.ui.screen.cart

import id.co.mondo.jetreward.model.OrderReward

data class CartState(
    val orderRewads: List<OrderReward>,
    val totalRequiredPoint: Int
)