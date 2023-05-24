package com.boxes.Service.services.interfaces

import com.boxes.Service.models.ClientLogin
import com.boxes.Service.models.EmployeeLogin

interface Login {
    fun checkEmlpoyee( login:EmployeeLogin):Boolean
    fun checkClient(email:String):Boolean
    fun loginClient(clientLogin: ClientLogin): Boolean
}