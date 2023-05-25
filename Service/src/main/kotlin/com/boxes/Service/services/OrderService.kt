package com.boxes.Service.services

import com.boxes.Service.components.DatabaseDriver
import com.boxes.Service.models.OrderInfo
import com.boxes.Service.models.ProcessedOrder
import com.boxes.Service.services.interfaces.Order
import org.springframework.stereotype.Service

@Service
class OrderService : Order {
    override fun findNewOrders(): List<OrderInfo> {
        return try {
            DatabaseDriver.findNewOrders()
        }
        catch (e:Exception){
            println(e.message)
            mutableListOf<OrderInfo>()
        }
    }

    override fun acceptOrder(processedOrder: ProcessedOrder): Boolean {
        return DatabaseDriver.acceptOrder(processedOrder)
    }

    override fun denyOrder(processedOrder: ProcessedOrder): Boolean {
        return DatabaseDriver.denyOrder(processedOrder)
    }

    override fun getClientOrders(email: String): List<OrderInfo> {

      return  try{
             DatabaseDriver.getClientOrders(email)


        }
        catch (e:Exception){
            println(e.message)
            mutableListOf<OrderInfo>()
        }

    }
}