package com.boxes.Service.services

import com.boxes.Service.models.EmployeeLogin
import org.springframework.stereotype.Service
import com.boxes.Service.components.DatabaseDriver
import java.lang.NullPointerException

@Service
class LoginService:Login {
    override fun checkEmlpoyee(login:EmployeeLogin): Boolean {
        return try {
            DatabaseDriver.checkEmployee(login)
        } catch (e:NullPointerException){
            false
        }
    }

    override fun checkClient(): Boolean {
        TODO("Not yet implemented")
    }
}