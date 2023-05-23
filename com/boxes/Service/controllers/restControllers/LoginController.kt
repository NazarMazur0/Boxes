package com.boxes.Service.controllers.restControllers

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
    fun employeeLogin(@RequestBody login: EmployeeLogin){
       if( loginService.checkEmlpoyee(login)){
           println("Employee logged")
       }
    }
}