package com.boxes.Service.services

import com.boxes.Service.models.EmployeeLogin

interface Login {
    fun checkEmlpoyee( login:EmployeeLogin):Boolean
    fun checkClient():Boolean
}