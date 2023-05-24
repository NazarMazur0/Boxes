package com.boxes.Service.controllers.restControllers

import com.boxes.Service.models.ClientLogin
import com.boxes.Service.models.EmployeeLogin
import com.boxes.Service.services.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/")
class LoginController(private val loginService: LoginService) {
    @PostMapping("employeeLogin")
    fun employeeLogin(@RequestBody login: EmployeeLogin):String{
        return  if( loginService.checkEmlpoyee(login)){
           "200"
       }
        else "500"
    }
    @PostMapping("clientLogin")
    fun clientLogin(@RequestBody email: String):String{
        return if( loginService.checkClient(email)){
            "200"
        } else "500"
    }
    @PostMapping("clientLoginWithCode")
    fun clientLogin(@RequestBody clientLogin: ClientLogin):String{
        return if(loginService.loginClient(clientLogin)){
            "200"
        } else "500"
    }

}