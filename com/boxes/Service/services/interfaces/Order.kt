package com.boxes.Service.services.interfaces

import com.boxes.Service.models.ProcessedOrder


interface Order {
    fun findNewOrders():String
    fun acceptOrder(processedOrder: ProcessedOrder):Boolean
    fun denyOrder(processedOrder: ProcessedOrder):Boolean
}