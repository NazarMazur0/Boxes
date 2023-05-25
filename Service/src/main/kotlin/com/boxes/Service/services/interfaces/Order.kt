package com.boxes.Service.services.interfaces

import com.boxes.Service.models.OrderInfo
import com.boxes.Service.models.ProcessedOrder


interface Order {
    fun findNewOrders():List<OrderInfo>
    fun acceptOrder(processedOrder: ProcessedOrder):Boolean
    fun denyOrder(processedOrder: ProcessedOrder):Boolean

    fun getClientOrders(email:String):List<OrderInfo>
}