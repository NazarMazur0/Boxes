package com.boxes.Service.controllers

import com.boxes.Service.models.EmployeeLogin
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
}