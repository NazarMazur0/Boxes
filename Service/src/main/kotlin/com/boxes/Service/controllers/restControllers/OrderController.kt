package com.boxes.Service.controllers.restControllers

import com.boxes.Service.models.ClientLogin
import com.boxes.Service.models.EmployeeLogin
import com.boxes.Service.models.ProcessedOrder
import com.boxes.Service.services.LoginService
import com.boxes.Service.services.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/")
class OrderController(val loginService: LoginService,val orderService: OrderService) {
    @PostMapping("/getNewOrders")
    fun newOrders(@RequestBody login: EmployeeLogin):String{
        return if(loginService.checkEmlpoyee(login))
            orderService.findNewOrders()
        else
            "500"
    }
    @PostMapping("/acceptOrder")
    fun acceptedOrder(@RequestBody processedOrder: ProcessedOrder):String{
        return if( orderService.acceptOrder(processedOrder)) "200"
        else "500"
    }
    @PostMapping("/denyOrder")
    fun denyOrder(@RequestBody processedOrder: ProcessedOrder):String{
        return if( orderService.denyOrder(processedOrder)) "200"
        else "500"
    }
    @PostMapping("/getClientOrders")
    fun getClientOrders(@RequestBody clientLogin: ClientLogin):String{
        return if(loginService.loginClient(clientLogin)){
            orderService.getClientOrders(clientLogin.email)
        } else ""

    }
}