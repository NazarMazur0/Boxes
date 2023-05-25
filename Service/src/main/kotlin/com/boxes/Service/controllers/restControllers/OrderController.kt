package com.boxes.Service.controllers.restControllers

import com.boxes.Service.models.ClientLogin
import com.boxes.Service.models.EmployeeLogin
import com.boxes.Service.models.OrderInfo
import com.boxes.Service.models.ProcessedOrder
import com.boxes.Service.services.LoginService
import com.boxes.Service.services.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("api/")
class OrderController(val loginService: LoginService,val orderService: OrderService) {
    @PostMapping("/getNewOrders")
    fun newOrders(@RequestBody login: EmployeeLogin):ModelAndView{
        val newOrders:List<OrderInfo>
        val model = ModelAndView("newOrders")
         if(loginService.checkEmlpoyee(login)){
            newOrders= orderService.findNewOrders()
        model.addObject("orders",newOrders)
    } else model.addObject("orders",mutableListOf<OrderInfo>())
    return model
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
    fun getClientOrders(@RequestBody clientLogin: ClientLogin):ModelAndView{
        val clientOrders:List<OrderInfo>
        val model = ModelAndView("clientOrders")
         if(loginService.loginClient(clientLogin)){
            clientOrders= orderService.getClientOrders(clientLogin.email)
             model.addObject("clientOrders",clientOrders)
        } else model.addObject("clientOrders",mutableListOf<OrderInfo>())
        return model
    }
}